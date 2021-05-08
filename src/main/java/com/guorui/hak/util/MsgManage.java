package com.guorui.hak.util;

import com.guorui.hak.pojo.*;
import com.guorui.hak.pojo.player.IPlayer;
import com.guorui.hak.pojo.player.impl.PlayerFactory;

//处理消息
public class MsgManage{

    public static void addInstruct(Instruct instruct) throws NoSuchMethodException {
        //instructs.offer(instruct);
        //对指令解析order后调用对应Player的对应逻辑函数
        IPlayer player = Room.players.get(instruct.getUid()+"");
        if (player == null){
            System.out.println("没有找到该用户！");
            return;
        }
        String order = instruct.getOrder();
        try {
            //通过反射调用指令函数,将instruct作为参数传入
            player.getClass().getMethod(order, Instruct.class).invoke(player,instruct);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("指令调用失败!该用户没有使用该指令的权限!");
        }
    }

    public static void join(Instruct instruct,String name){
        //在Room里面加入...
        try {
            Class clazz = Class.forName("com.guorui.hak.pojo.player.impl." + Players.getRandomPlayer().toString());
            Room.players.put(instruct.getUid() + "" , PlayerFactory.createPlayer(clazz,name,instruct.getUid()));
        }catch (Exception e){
            System.out.println("随机生成Player异常");
            e.printStackTrace();
        }
    }


}
