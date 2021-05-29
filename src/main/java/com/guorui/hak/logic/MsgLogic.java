package com.guorui.hak.logic;


import com.guorui.hak.dao.UserDao;
import com.guorui.hak.entity.player.impl.PlayerPeople;
import com.guorui.hak.netty.TextWebSocketFrameHandler;
import com.guorui.hak.entity.room.Room;
import com.guorui.hak.entity.player.IPlayer;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import net.sf.json.JSONObject;

import java.util.Map;

//每个房间独有的一个线程,存放在线程池中
public class MsgLogic implements Runnable{

    public static UserDao userDao;

    Room room = new Room();

    @Override
    public void run() {
        while(true) {
            //广播房间信息...
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (Room.players == null || Room.players.isEmpty()) {
                continue;
            }
            for (Map.Entry<String, PlayerPeople> entry : Room.players.entrySet()) {
                JSONObject jsonObject = JSONObject.fromObject(Room.players);
                TextWebSocketFrameHandler.channelMap.get(entry.getKey() + "").writeAndFlush(new TextWebSocketFrame(jsonObject.toString()));
            }
        }
    }
}
