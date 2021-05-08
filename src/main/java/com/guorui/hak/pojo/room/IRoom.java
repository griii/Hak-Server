package com.guorui.hak.pojo.room;

import com.guorui.hak.pojo.player.IPlayer;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

//通用房间接口
public interface IRoom {

    //房间类型
    public String RoomType = null;
    //所有用户
    public ConcurrentHashMap<String, IPlayer> users = new ConcurrentHashMap<>();

    public HashMap<String,IPlayer> getUsers();

}
