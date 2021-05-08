package com.guorui.hak.pojo;

public class Instruct {

    private String order;
    private long time;
    private Object obj;
    private int roomId;
    private int uid;

    @Override
    public String toString() {
        return "Instruct{" +
                "order='" + order + '\'' +
                ", time=" + time +
                ", obj=" + obj +
                ", roomId=" + roomId +
                ", uid=" + uid +
                '}';
    }

    public Instruct(String order, long time, Object obj, int roomId, int uid) {
        this.order = order;
        this.time = time;
        this.obj = obj;
        this.roomId = roomId;
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
