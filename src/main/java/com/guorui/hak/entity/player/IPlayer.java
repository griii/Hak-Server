package com.guorui.hak.entity.player;

import com.guorui.hak.entity.instruct.Instruct;

public interface IPlayer extends Runnable {

    public void move(Instruct instruct);
    public void moveOut(Instruct instruct);

}
