package com.guorui.hak.entity.room.impl;


import com.guorui.hak.entity.exception.MyException;
import com.guorui.hak.entity.instruct.Instruct;
import com.guorui.hak.entity.instruct.strategy.InstructStrategy;
import com.guorui.hak.entity.player.IPlayer;
import com.guorui.hak.entity.player.impl.PlayerPeople;
import com.guorui.hak.entity.room.IRoom;
import com.guorui.hak.util.MapCapacityUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

//房间信息
public abstract class AbstractRoom implements IRoom {

    @Autowired
    private ApplicationContext applicationContext;

    public AbstractRoom() {
        init();
    }

    //游戏房间是否正在执行，若正在执行则广播...
    private volatile boolean isRun;
    public boolean runNow(){
        return isRun;
    }

    protected ConcurrentHashMap<String, PlayerPeople> players;

    protected BlockingQueue<Instruct> instructs;

    @Override
    public ConcurrentHashMap<String, PlayerPeople> getUsers() {
        return this.players;
    }

    @Override
    public void setUsers(PlayerPeople[] playerPeoples) throws MyException{
        if (playerPeoples.length > getCapacity()){
            throw new MyException("容量错误!");
        }
        for (int i = 0; i < playerPeoples.length; i++) {
            this.players.put(playerPeoples[i].getUid()+"",playerPeoples[i]);
        }
    }

    //默认实现的添加指令消息方法
    @Override
    public void addInstruct(Instruct instruct){
        if (instructs == null)
            throw new RuntimeException("添加指令消息时还未init!");
        instructs.add(instruct);
    }

    //以下为生命周期的默认实现==============================================
    @Override
    public void init(){
        this.players = new ConcurrentHashMap<>(MapCapacityUtil.tableSizeFor(getCapacity()));
        this.instructs = new LinkedBlockingQueue<>();
    }

    @Override
    public void load(PlayerPeople[] playerPeople) throws MyException{
        setUsers(playerPeople);
    }

    //线程
    @SneakyThrows
    @Override
    public void run(){
        isRun = true;
        while(isRun) {
            Instruct instruct = instructs.take();
            PlayerPeople player = players.get(instruct.getUid() + "");
            if (player == null) {
                System.out.println("没有找到该用户！");
                return;
            }
            String order = instruct.getOrder();
            try {
                //通过Spring的BeanFactory获取
                String strategyName = order + STRATEGY;
                InstructStrategy is = (InstructStrategy) applicationContext.getBean(order + STRATEGY);
                //InstructStrategy is = (InstructStrategy)(Class.forName("com.guorui.hak.entity.instruct.strategy.impl." + strategyName).getConstructor().newInstance());
                is.instructOrder(instruct, player);
                //player.getClass().getMethod(order, Instruct.class).invoke(player,instruct);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("指令调用失败!该用户没有使用该指令的权限!");
            }
        }
    }


}
