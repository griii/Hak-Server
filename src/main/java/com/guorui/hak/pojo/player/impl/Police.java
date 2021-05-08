package com.guorui.hak.pojo.player.impl;

import com.guorui.hak.pojo.Instruct;
import com.guorui.hak.pojo.player.IPolice;

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
