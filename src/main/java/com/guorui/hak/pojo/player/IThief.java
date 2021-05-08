package com.guorui.hak.pojo.player;


import com.guorui.hak.pojo.Instruct;

//小偷接口
public interface IThief extends IPlayer {

    //偷窃
    public void steal(Instruct instruct);


}
