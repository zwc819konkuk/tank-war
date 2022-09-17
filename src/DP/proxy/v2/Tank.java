package DP.proxy.v2;

import java.util.Random;

/**
 * 我想记录坦克的移动时间
 * 如果无法改变方法源码？
 * 使用继承？耦合度太高了
 */
public class Tank implements Movable {
    @Override
    public void move() {
        System.out.println("tank moving");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Tank2().move();
    }
}
class Tank2 extends Tank{
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        super.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
interface Movable {
    void move();
}
