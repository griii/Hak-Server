package com.guorui.hak.entity.player;


import com.guorui.hak.entity.Instruct;

//小偷接口
public interface IThief extends IPlayer {

    //偷窃
    public void steal(Instruct instruct);


}
