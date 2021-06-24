package com.guorui.hak.logic.thread;

import com.guorui.hak.entity.room.IRoom;
import org.springframework.stereotype.Component;

@Component
public class RoomThreadLocal<T extends IRoom> extends ThreadLocal<T> {



}
