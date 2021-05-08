package com.guorui.hak.logic;


import com.guorui.hak.dao.UserDao;
import com.guorui.hak.netty.TextWebSocketFrameHandler;
import com.guorui.hak.pojo.Room;
import com.guorui.hak.pojo.player.IPlayer;
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
            for (Map.Entry<String, IPlayer> entry : Room.players.entrySet()) {
                JSONObject jsonObject = JSONObject.fromObject(Room.players);
                //System.out.println(entry.getValue().toString());
                //System.out.println("uid" + entry.getKey() + "广播内容" + jsonObject.toString());
                //System.out.println(TextWebSocketFrameHandler.channelMap.toString());
                TextWebSocketFrameHandler.channelMap.get(entry.getKey() + "").writeAndFlush(new TextWebSocketFrame(jsonObject.toString()));
            }
        }
    }
}
