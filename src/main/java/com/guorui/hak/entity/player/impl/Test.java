package com.guorui.hak.entity.player.impl;

import com.guorui.hak.entity.Instruct;
import com.guorui.hak.entity.player.IPlayer;

import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, InterruptedException {
        IPlayer player = PlayerFactory.createPlayer(NormalPlayer.class,"测试",123456);
        player.move(new Instruct("",1,45,1,1));
        Thread.sleep(1000);
        System.out.println("结束暴动");
        player.moveOut(new Instruct("",1,45,1,1));
    }

}
