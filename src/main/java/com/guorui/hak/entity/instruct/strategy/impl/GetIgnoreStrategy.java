package com.guorui.hak.entity.instruct.strategy.impl;

import com.guorui.hak.entity.instruct.Instruct;
import com.guorui.hak.entity.instruct.strategy.InstructStrategy;
import com.guorui.hak.entity.player.impl.PlayerPeople;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
public class GetIgnoreStrategy implements InstructStrategy {

    @Override
    public void instructOrder(Instruct instruct, PlayerPeople player) {
        //使用装饰者模式实现...

    }

}
