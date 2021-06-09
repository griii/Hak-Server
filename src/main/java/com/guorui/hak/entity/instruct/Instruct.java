package com.guorui.hak.entity.instruct;


import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
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

}
