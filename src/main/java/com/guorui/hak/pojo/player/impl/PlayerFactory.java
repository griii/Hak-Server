package com.guorui.hak.pojo.player.impl;


import com.guorui.hak.pojo.player.IPlayer;

import java.lang.reflect.InvocationTargetException;

//简单工厂创建Player
public class PlayerFactory {
    public static IPlayer createPlayer(Class<? extends IPlayer> clazz, String userName, int uid)
            throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        return (IPlayer) clazz.getDeclaredConstructor(double.class,double.class,int.class,int.class,boolean.class,double.class,float.class,String.class).newInstance(0,0,uid,123,false,0,3,userName);
    }
}
