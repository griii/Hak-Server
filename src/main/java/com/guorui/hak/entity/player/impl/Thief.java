package com.guorui.hak.entity.player.impl;

import com.guorui.hak.entity.instruct.Instruct;
import com.guorui.hak.entity.player.IThief;

public class Thief extends PlayerPeople implements IThief {


    public Thief(double x, double y, int uid, int token, boolean move, double angle, float speed, String name) {
        super(x, y, uid, token, move, angle, speed, name);
    }

    @Override
    public void steal(Instruct instruct) {

    }
}
