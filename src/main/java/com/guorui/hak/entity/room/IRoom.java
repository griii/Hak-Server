package com.guorui.hak.entity.room;

import com.guorui.hak.entity.instruct.Instruct;
import com.guorui.hak.entity.player.IPlayer;
import com.guorui.hak.entity.player.impl.PlayerPeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

//通用房间接口
public interface IRoom extends Runnable {

    public static final String STRATEGY = "Strategy";

    //获取所有用户
    ConcurrentHashMap<String,PlayerPeople> getUsers();

    //设置所有用户
    void setUsers(PlayerPeople[] playerPeoples);

    //获取Map容量，适用于初始化
    int getCapacity();

    //获取游戏线程是否进行中
    boolean runNow();

    //在Room维护的阻塞队列里添加指令消息
    void addInstruct(Instruct instruct);

    //以下是生命周期=============================================================

    //初始化，在无参构造器中调用，不需要自行调用！
    //2021年6月23日22:09:55设定 init周期为初始化Room内的Players容器
    void init();

    //加载
    //2021年6月23日22:10:14设定 load周期为填充Players容器
    void load(PlayerPeople[] playerPeople);

    //真正开始游戏
    void startGame();

    //结束
    void finish();
}
