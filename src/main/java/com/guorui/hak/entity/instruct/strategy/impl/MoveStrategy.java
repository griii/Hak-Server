package com.guorui.hak.entity.instruct.strategy.impl;

import com.guorui.hak.entity.Instruct;
import com.guorui.hak.entity.instruct.strategy.InstructStrategy;
import com.guorui.hak.entity.player.IPlayer;
import com.guorui.hak.entity.player.impl.PlayerPeople;


//跑动策略
public class MoveStrategy implements InstructStrategy {

    @Override
    public void instructOrder(Instruct instruct, PlayerPeople player) {
        if (player.isMove() != true) {
            player.setMove(true);
            //新建一个线程
            new Thread(player).start();//后续重构改为线程池...
        }else {
            //跑动线程已存在不需要再创建
        }
        player.setTime(System.currentTimeMillis());
        player.setAngle(Double.valueOf(instruct.getObj()+""));
    }

}
