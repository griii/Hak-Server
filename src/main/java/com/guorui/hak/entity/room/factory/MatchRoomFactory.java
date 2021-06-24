package com.guorui.hak.entity.room.factory;

import com.guorui.hak.entity.exception.MyException;
import com.guorui.hak.entity.player.impl.PlayerPeople;
import com.guorui.hak.entity.room.IRoom;
import com.guorui.hak.logic.thread.MainGameLogicThread;
import com.guorui.hak.logic.thread.MainLogicThreadPool;
import com.guorui.hak.netty.TextWebSocketFrameHandler;
import com.guorui.hak.util.CharsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.xml.soap.Text;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

@Component
public class MatchRoomFactory implements IRoomFactory {

    //优先队列映射集合
    private Map<Class<? extends IRoom>, PriorityQueue<PlayerPeople>> queueMap = new ConcurrentHashMap<>();

    @Autowired
    private ApplicationContext applicationContext;

    @Qualifier("mainLogicPool")
    @Autowired
    private ExecutorService mainLogicPool;

    //用户加入匹配...
    public void join(String roomType,PlayerPeople playerPeople){
        try {
            Class<? extends IRoom> clazz = (Class<? extends IRoom>) Class.forName("com.guorui.hak.entity.room.impl." + roomType);
            if (!queueMap.containsKey(clazz)) {
                //如果不存在，要注意并发安全问题：不能创建多个相同的队列，也就是要做到单例模式
                //由于这个并发问题出现的频率很小啊，所以直接锁就完了
                synchronized (queueMap) {
                    if (queueMap.containsKey(clazz)) {
                        //经典双重检查
                    }
                    queueMap.put(clazz, new PriorityQueue<>());
                }
            }
            Queue queue = queueMap.get(clazz);
            queue.add(playerPeople);
            try{
                //CAPACITY作为实现类的final static字段,直接通过反射拿了
                Field field = clazz.getDeclaredField("CAPACITY");
                field.setAccessible(true);
                int capcity = (int) field.get(clazz);
                if (queue.size() >= capcity){
                    IRoom room = (IRoom) applicationContext.getBean(CharsUtil.firstToSmallCase(roomType));
                    PlayerPeople[] people = new PlayerPeople[capcity];
                    for (int i = 0; i < capcity; i++) {
                        people[i] = (PlayerPeople) queue.element();//用element方法会抛出异常
                    }
                    //调用room的生命周期：load周期，填充PlayerPeople
                    room.load(people);
                    //至此为止,匹配成功了,将这个room添加到核心线程的ThreadLocal中，线程添加到线程池，启动!
                    startThreadRoom(room);
                }
            }catch (Exception e){
                e.printStackTrace();
                if (e instanceof MyException){
                    //说明是内部再次抛出来的
                    throw e;
                }
                throw new RuntimeException("实现类的CAPACITY字段有误!");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("加入匹配的房间类型格式错误!");
        }
    }


    @Override
    public void startThreadRoom(IRoom room) {
        //向RoomMap中添加映射
        for (String s:room.getUsers().keySet()){
            TextWebSocketFrameHandler.roomMap.put(s,room);
        }
        MainGameLogicThread mainGameLogicThread = (MainGameLogicThread) applicationContext.getBean("mainGameLogicThread");
        mainGameLogicThread.setRoom(room);
        mainLogicPool.execute(mainGameLogicThread);
        mainLogicPool.execute(room);
    }
}
