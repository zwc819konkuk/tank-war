package DP.proxy.v1;

import java.util.Random;

/**
 * 我想记录坦克的移动时间
 */
public class Tank implements Movable {
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("tank moving");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) {
        new Tank().move();
    }
}
