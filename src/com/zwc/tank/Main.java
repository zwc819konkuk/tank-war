package com.zwc.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        TankFrame tf = new TankFrame();

        //初始化敌方坦克
        for (int i = 0; i < 8; i++) {
            tf.tanks.add(new Tank(50 + i * 80, 200,Dir.DOWN, Group.BAD, tf));
        }

        //背景音效
        new Thread(() -> new Audio("audios/war1.wav").loop()).start();

        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
