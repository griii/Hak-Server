package com.guorui.hak.pojo.player.impl;

import com.guorui.hak.pojo.Instruct;
import com.guorui.hak.pojo.player.IPlayer;

public class PlayerPeople implements IPlayer {

    private double x;
    private double y;
    private int uid;
    private int token;
    private String name;
    private boolean move = false;
    private double angle;
    private float speed = 30;
    private long time;

    public PlayerPeople(double x, double y, int uid, int token, boolean move, double angle, float speed,String name) {
        this.x = x;
        this.y = y;
        this.uid = uid;
        this.token = token;
        this.move = move;
        this.angle = angle;
        this.speed = speed;
        this.name = name;
    }



    @Override
    public void move(Instruct instruct) {
        if (this.move != true) {
            this.move = true;
            //新建一个线程
            new Thread(this).start();//后续重构改为线程池...
        }else {
            //跑动线程已存在不需要再创建
        }
        this.time = System.currentTimeMillis();//由于前后端时间差过大，这里先设为当前时间
        this.angle = Double.valueOf(instruct.getObj()+"");
    }

    @Override
    public void moveOut(Instruct instruct) {
        this.move = false;
    }

    @Override
    public void run() {
        System.out.println("开始跑动线程...");
        //这里执行需要长期计算的指令逻辑(如跑动等)
        //("跑动线程")
        long timeDiffer = 0;
        while(this.move){
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized ((Long)time) {
                timeDiffer = System.currentTimeMillis() - time;
                time = System.currentTimeMillis();
                this.x = (this.x + (timeDiffer * this.speed * 0.1F * Math.sin(Math.PI / 180 * this.angle)));
                this.y = (this.y - (timeDiffer * this.speed * 0.1F * Math.cos(Math.PI / 180 * this.angle)));
            }
        }
        System.out.println("跑动线程退出");
    }

    @Override
    public String toString() {
        return "PlayerPeople{" +
                "x=" + x +
                ", y=" + y +
                ", uid=" + uid +
                ", token=" + token +
                ", name='" + name + '\'' +
                ", move=" + move +
                ", angle=" + angle +
                ", speed=" + speed +
                ", time=" + time +
                '}';
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
