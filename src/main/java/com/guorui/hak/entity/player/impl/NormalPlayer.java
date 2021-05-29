package com.guorui.hak.entity.player.impl;

import com.guorui.hak.entity.player.INormalPlayer;

public class NormalPlayer extends PlayerPeople implements INormalPlayer {


    public NormalPlayer(double x, double y, int uid, int token, boolean move, double angle, float speed, String name) {
        super(x, y, uid, token, move, angle, speed, name);
    }

}
