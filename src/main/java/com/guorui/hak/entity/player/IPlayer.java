package com.guorui.hak.entity.player;

import com.guorui.hak.entity.Instruct;

public interface IPlayer extends Runnable {

    public void move(Instruct instruct);
    public void moveOut(Instruct instruct);

}
