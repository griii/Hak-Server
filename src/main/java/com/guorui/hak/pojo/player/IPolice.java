package com.guorui.hak.pojo.player;

import com.guorui.hak.pojo.Instruct;

//警察接口
public interface IPolice extends IPlayer {

    //射击
    public void shut(Instruct instruct);

    //抓捕
    public void arrest(Instruct instruct);
}
