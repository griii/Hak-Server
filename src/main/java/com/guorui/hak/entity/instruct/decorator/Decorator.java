package com.guorui.hak.entity.instruct.decorator;

import com.guorui.hak.entity.Instruct;
import com.guorui.hak.entity.player.IPlayer;
import com.guorui.hak.entity.player.impl.PlayerPeople;
import com.guorui.hak.entity.room.Room;

//装饰类
public abstract class Decorator extends PlayerPeople{

    PlayerPeople component;

    public void Decorator(PlayerPeople component){
        this.component = component;
    }

    //装饰过程 用本类代替Room中的原类...
    public abstract void dec();

    @Override
    public void move(Instruct instruct) {
        component.move(instruct);
    }

    @Override
    public void moveOut(Instruct instruct) {
        component.moveOut(instruct);
    }

    @Override
    public void run() {
        component.run();
    }

    @Override
    public String toString() {
        return component.toString();
    }

    @Override
    public double getX() {
        return component.getX();
    }

    @Override
    public void setX(double x) {
        component.setX(x);
    }

    @Override
    public double getY() {
        return component.getY();
    }

    @Override
    public void setY(double y) {
        component.setY(y);
    }

    @Override
    public int getUid() {
        return component.getUid();
    }

    @Override
    public void setUid(int uid) {
        component.setUid(uid);
    }

    @Override
    public int getToken() {
        return component.getToken();
    }

    @Override
    public void setToken(int token) {
        component.setToken(token);
    }

    @Override
    public String getName() {
        return component.getName();
    }

    @Override
    public void setName(String name) {
        component.setName(name);
    }

    @Override
    public boolean isMove() {
        return component.isMove();
    }

    @Override
    public void setMove(boolean move) {
        component.setMove(move);
    }

    @Override
    public double getAngle() {
        return component.getAngle();
    }

    @Override
    public void setAngle(double angle) {
        component.setAngle(angle);
    }

    @Override
    public float getSpeed() {
        return component.getSpeed();
    }

    @Override
    public void setSpeed(float speed) {
        component.setSpeed(speed);
    }

    @Override
    public long getTime() {
        return component.getTime();
    }

    @Override
    public void setTime(long time) {
        component.setTime(time);
    }
}
