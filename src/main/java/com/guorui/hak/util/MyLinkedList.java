//package com.example.nettydemo.util;
//
//import com.example.nettydemo.pojo.Instruct;
//
//import java.util.LinkedList;
//
//public class MyLinkedList extends LinkedList<Instruct> {
//
//    @Override
//    public boolean offer(Instruct instruct) {
//        super.offer(instruct);
//        MsgManage.instruct = this.poll();//返回后删除
//        switch (instruct.getOrder()) {
//            case "MOVE":
//                MsgManage.move();
//                break;
//            case "JOIN":
//                MsgManage.join();
//                break;
//            case "MOVEOUT":
//                MsgManage.moveOut();
//                break;
//        }
//        return true;
//    }
//}
