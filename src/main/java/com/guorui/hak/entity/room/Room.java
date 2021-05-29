package com.guorui.hak.entity.room;


import com.guorui.hak.entity.player.IPlayer;
import com.guorui.hak.entity.player.impl.PlayerPeople;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

//房间信息
public class Room implements IRoom {

    public static ConcurrentHashMap<String, PlayerPeople> players = new ConcurrentHashMap<>();

    @Override
    public HashMap<String, PlayerPeople> getUsers() {
        return null;
    }
}
