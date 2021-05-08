package com.guorui.hak.pojo;


import com.guorui.hak.pojo.player.IPlayer;

import java.util.concurrent.ConcurrentHashMap;

//房间信息
public class Room {

    public static ConcurrentHashMap<String, IPlayer> players = new ConcurrentHashMap<>();

}
