//package com.example.nettydemo.pojo;
//
//public class PlayerMoving extends Player implements Runnable {
//
//    private long time;
//
//    public PlayerMoving(double x, double y, int uid, int token, boolean move, double angle, float speed) {
//        super(x, y, uid, token, move, angle, speed);
//    }
//
//    public long getTime() {
//        return time;
//    }
//
//    public PlayerMoving setTime(long time) {
//        this.time = time;
//        return this;
//    }
//
//    @Override
//    public void run() {
//        //System.out.println("跑动线程启动了,当前move情况" + this.getMove() + "超类情况" + super.getMove());
//        long timeDiffer = 0;
//        while(this.getMove()){
//            try {
//                Thread.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            synchronized ((Long)time) {
//                timeDiffer = System.currentTimeMillis() - time;
//                time = System.currentTimeMillis();
//                this.setX(this.getX() + (timeDiffer * this.getSpeed() * 0.1F * Math.sin(Math.PI / 180 * this.getAngle())));
//                //System.out.println("角度=" + this.getAngle() + "X=" + timeDiffer + "*" + this.getSpeed() + "* 0.1 *" + Math.sin(Math.PI / 180 * this.getAngle()));
//                this.setY(this.getY() - (timeDiffer * this.getSpeed() * 0.1F * Math.cos(Math.PI / 180 * this.getAngle())));
//                //System.out.println("Y=" + timeDiffer + "*" + this.getSpeed() + "* 0.1 *" + Math.cos(Math.PI / 180 * this.getAngle()));
//                //System.out.println("修改后 x:" + this.getX() + "y:" + this.getY());
//                Player player = Room.players.get(this.getUid() + "");
//                //System.out.println(Room.users.toString());
//                //System.out.println(user);
//                player.setX(this.getX());
//                player.setY(this.getY());
//                //System.out.println("跑动线程..." + user.toString());
//            }
//        }
//    }
//
//}
