package com.guorui.hak.entity.player;

import com.guorui.hak.entity.instruct.Instruct;

//警察接口
public interface IPolice extends IPlayer {

    //射击
    public void shut(Instruct instruct);

    //抓捕
    public void arrest(Instruct instruct);
}
