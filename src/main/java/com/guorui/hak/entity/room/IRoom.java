package com.guorui.hak.entity.room;

import com.guorui.hak.entity.player.IPlayer;
import com.guorui.hak.entity.player.impl.PlayerPeople;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

//通用房间接口
public interface IRoom {

    //房间类型
    public String RoomType = null;
    //所有用户
    public ConcurrentHashMap<String, PlayerPeople> users = new ConcurrentHashMap<>();

    public HashMap<String,PlayerPeople> getUsers();

}
