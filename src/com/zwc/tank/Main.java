package com.zwc.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        TankFrame tf = new TankFrame();

        //背景音效
        new Thread(() -> new Audio("audios/war1.wav").loop()).start();

        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
