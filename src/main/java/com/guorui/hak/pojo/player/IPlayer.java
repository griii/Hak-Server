package com.guorui.hak.pojo.player;

import com.guorui.hak.pojo.Instruct;

public interface IPlayer extends Runnable {

    public void move(Instruct instruct);
    public void moveOut(Instruct instruct);

}
