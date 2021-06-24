package com.guorui.hak.entity.room.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class Default3V3Room extends AbstractRoom {

    private static final int CAPACITY = 1;

    @Override
    public int getCapacity() {
        return CAPACITY;
    }

    @Override
    public void startGame() {

    }

    @Override
    public void finish() {

    }
}
