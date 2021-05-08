package com.guorui.hak.pojo.player.impl;

import com.guorui.hak.pojo.player.INormalPlayer;

public class NormalPlayer extends PlayerPeople implements INormalPlayer {


    public NormalPlayer(double x, double y, int uid, int token, boolean move, double angle, float speed, String name) {
        super(x, y, uid, token, move, angle, speed, name);
    }
}
