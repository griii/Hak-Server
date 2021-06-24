package com.guorui.hak.entity.room.factory;

import com.guorui.hak.entity.player.impl.PlayerPeople;
import com.guorui.hak.entity.room.IRoom;

//创建Room的工厂
public interface IRoomFactory {

    void join(String roomType, PlayerPeople playerPeople);

    //核心方法，将新建的Room加入核心线程池中执行...
    void startThreadRoom(IRoom room);



}
