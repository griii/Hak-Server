package com.guorui.hak.util;

import com.guorui.hak.entity.instruct.Instruct;
import com.guorui.hak.entity.instruct.strategy.InstructStrategy;
import com.guorui.hak.entity.player.Players;
import com.guorui.hak.entity.player.impl.PlayerFactory;
import com.guorui.hak.entity.player.impl.PlayerPeople;
import com.guorui.hak.entity.room.factory.IRoomFactory;
import com.guorui.hak.entity.room.factory.MatchRoomFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

//处理消息
@Component
public class MsgManage{

    @Autowired
    private ApplicationContext applicationContext;

    private static final String STRATEGY = "Strategy";

//    public void addInstruct(Instruct instruct) throws NoSuchMethodException {
//        //instructs.offer(instruct);
//        //对指令解析order后调用对应Player的对应逻辑函数
//        PlayerPeople player = Room.players.get(instruct.getUid()+"");
//        if (player == null){
//            System.out.println("没有找到该用户！");
//            return;
//        }
//        String order = instruct.getOrder();
//        try {
//            //通过Spring的BeanFactory获取
//            String strategyName = order + STRATEGY;
//            InstructStrategy is = (InstructStrategy) applicationContext.getBean(order + STRATEGY);
//            //InstructStrategy is = (InstructStrategy)(Class.forName("com.guorui.hak.entity.instruct.strategy.impl." + strategyName).getConstructor().newInstance());
//            is.instructOrder(instruct,player);
//            //player.getClass().getMethod(order, Instruct.class).invoke(player,instruct);
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("指令调用失败!该用户没有使用该指令的权限!");
//        }
//    }

    public void join(Instruct instruct,String name){
        //在Room里面加入...
        //改为在等待队列中加入...
        try {
            Class clazz = Class.forName("com.guorui.hak.entity.player.impl." + Players.getRandomPlayer().toString());
            //Room.players.put(instruct.getUid() + "" , PlayerFactory.createPlayer(clazz,name,instruct.getUid()));
            IRoomFactory factory = (MatchRoomFactory) applicationContext.getBean("matchRoomFactory");
            factory.join(instruct.getObj()+"",PlayerFactory.createPlayer(clazz,name,instruct.getUid()));
        }catch (Exception e){
            System.out.println("随机生成Player异常");
            e.printStackTrace();
        }
    }


}
