//package com.example.nettydemo.pojo;
//
//
//public class Player {
//
//    private double x;
//    private double y;
//    private int uid;
//    private int token;
//    private boolean move = false;
//    private double angle;
//    private float speed = 30;
//    public PlayerMoving playerMoving;
//
//    public void instanceMoving(long time){
//        this.playerMoving = new PlayerMoving(this.x,this.y,this.uid,this.token,this.move,this.angle,this.speed).setTime(time);
//    }
//
//    public Player(double x, double y, int uid, int token, boolean move, double angle, float speed) {
//        this.x = x;
//        this.y = y;
//        this.uid = uid;
//        this.token = token;
//        this.move = move;
//        this.angle = angle;
//        this.speed = speed;
//    }
//
//    public boolean getMove() {
//        return move;
//    }
//
//    public void setMove(boolean move) {
//        this.move = move;
//    }
//
//    public float getSpeed() {
//        return speed;
//    }
//
//    public void setSpeed(float speed) {
//        this.speed = speed;
//    }
//
//    public double getX() {
//        return x;
//    }
//
//    public void setX(double x) {
//        this.x = x;
//    }
//
//    public double getY() {
//        return y;
//    }
//
//    public void setY(double y) {
//        this.y = y;
//    }
//
//    public boolean isMove() {
//        return move;
//    }
//
//    public int getUid() {
//        return uid;
//    }
//
//    public void setUid(int uid) {
//        this.uid = uid;
//    }
//
//    public int getToken() {
//        return token;
//    }
//
//    public void setToken(int token) {
//        this.token = token;
//    }
//
//    public double getAngle() {
//        return angle;
//    }
//
//    public void setAngle(double angle) {
//        this.angle = angle;
//    }
//}
