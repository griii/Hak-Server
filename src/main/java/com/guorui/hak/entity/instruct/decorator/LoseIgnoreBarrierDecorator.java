package com.guorui.hak.entity.instruct.decorator;

import com.guorui.hak.entity.room.Room;

public class LoseIgnoreBarrierDecorator extends Decorator {
    @Override
    public void dec() {
        Room.players.put(component.getUid() + "",component);
    }
}
