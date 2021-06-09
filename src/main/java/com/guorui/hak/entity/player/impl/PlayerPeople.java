package com.guorui.hak.entity.player.impl;

import com.guorui.hak.entity.instruct.Instruct;
import com.guorui.hak.entity.player.IPlayer;
import lombok.Data;

@Data
public abstract class PlayerPeople implements IPlayer {

    private double x;
    private double y;
    private int uid;
    private int token;
    private String name;
    private boolean move = false;
    private double angle;
    private float speed = 30;
    private long time;

    public PlayerPeople(){

    };

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
    }

    @Override
    public String toString() {
        return "[" +
                String.format("%5.2f",x) + "," +
                String.format("%5.2f",y) + "]" + "{" +
                (move?"T":"F") + "," +
                String.format("a:%3.1f",angle) +
                ",s:" + speed +
                '}';
    }


}
