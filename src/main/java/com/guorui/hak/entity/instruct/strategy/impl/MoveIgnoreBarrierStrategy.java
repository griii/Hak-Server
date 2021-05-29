package com.guorui.hak.entity.instruct.strategy.impl;

import com.guorui.hak.entity.Instruct;
import com.guorui.hak.entity.instruct.decorator.GetIgnoreBarrierDecorator;
import com.guorui.hak.entity.instruct.strategy.InstructStrategy;
import com.guorui.hak.entity.player.impl.PlayerPeople;

//可穿墙移动指令
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
