package com.guorui.hak.logic.thread;

import com.guorui.hak.entity.instruct.Instruct;
import com.guorui.hak.entity.player.impl.PlayerPeople;
import com.guorui.hak.entity.room.IRoom;
import com.guorui.hak.netty.TextWebSocketFrameHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Scope("prototype")
@Component
public class MainGameLogicThread implements Runnable {

    private IRoom room;

    public void setRoom(IRoom room){
        this.room = room;
    }

    @Override
    public void run() throws RuntimeException {
        System.out.println(room);
        Map<String,PlayerPeople> players = room.getUsers();
        System.out.println("广播线程...");
        //如果游戏时间停止，线程终止...
        while(room.runNow()){
            //广播房间信息...
            if (players == null || players.isEmpty()) {
                throw new RuntimeException("游戏房间线程中没有玩家存在!");
            }
            for (Map.Entry<String, PlayerPeople> entry : players.entrySet()) {
                JSONObject jsonObject = JSONObject.fromObject(players);
                TextWebSocketFrameHandler.channelMap.get(entry.getKey() + "").writeAndFlush(new TextWebSocketFrame(jsonObject.toString()));
            }
        }


    }

}

