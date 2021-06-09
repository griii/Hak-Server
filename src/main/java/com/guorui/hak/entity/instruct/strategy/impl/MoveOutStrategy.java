package com.guorui.hak.entity.instruct.strategy.impl;

import com.guorui.hak.entity.instruct.Instruct;
import com.guorui.hak.entity.instruct.strategy.InstructStrategy;
import com.guorui.hak.entity.player.impl.PlayerPeople;
import org.springframework.stereotype.Component;


@Component
public class MoveOutStrategy implements InstructStrategy {

    @Override
    public void instructOrder(Instruct instruct, PlayerPeople player) {
        player.setMove(false);
    }

}
