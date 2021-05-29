package com.guorui.hak.entity.instruct.decorator;

import com.guorui.hak.entity.room.Room;

public class GetIgnoreBarrierDecorator extends Decorator {

    @Override
    public void dec() {
        Room.players.put(component.getUid() + "",this);
    }

}
