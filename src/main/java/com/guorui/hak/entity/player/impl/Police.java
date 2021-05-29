package com.guorui.hak.entity.player.impl;

import com.guorui.hak.entity.Instruct;
import com.guorui.hak.entity.player.IPolice;

public class Police extends PlayerPeople implements IPolice {


    public Police(double x, double y, int uid, int token, boolean move, double angle, float speed, String name) {
        super(x, y, uid, token, move, angle, speed, name);
    }

    @Override
    public void shut(Instruct instruct) {

    }

    @Override
    public void arrest(Instruct instruct) {

    }
}
