package com.guorui.hak.entity.player;

import java.util.Random;

public enum Players {

    NormalPlayer(30),
    Police(60),
    Thief(100);

    //选择中的几率(前减后)
    private int probability;
    private static Random random = new Random();
    Players(int probability) {
        this.probability = probability;
    }

    public static Players getRandomPlayer() {
        int r = random.nextInt(99)+1;
        for (Players p : values()){
            if (p.probability > r){
                return p;
            }
        }
        //如果失败了则随机返回
        return values()[random.nextInt(values().length)];
    }

}
