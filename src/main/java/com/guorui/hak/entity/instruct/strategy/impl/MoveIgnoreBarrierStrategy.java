package com.guorui.hak.entity.instruct.strategy.impl;

import com.guorui.hak.entity.instruct.Instruct;
import com.guorui.hak.entity.instruct.decorator.GetIgnoreBarrierDecorator;
import com.guorui.hak.entity.instruct.strategy.InstructStrategy;
import com.guorui.hak.entity.player.impl.PlayerPeople;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

//可穿墙移动指令
@Component
public class MoveIgnoreBarrierStrategy implements InstructStrategy {

    @Override
    public void instructOrder(Instruct instruct, PlayerPeople player) {
        if (player instanceof GetIgnoreBarrierDecorator){
            //可穿墙的Move逻辑
        }else{
            //策略降级
            new MoveStrategy().instructOrder(instruct,player);
        }
    }
}
