package DP.proxy.v3;


import java.util.Random;

/**
 * 我想记录坦克的移动时间
 * 如果无法改变方法源码？
 * 使用继承？耦合度太高了
 * v3:使用代理[聚合]
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
        new TankTimeProxy(new Tank()).move();
    }
}

class TankTimeProxy implements Movable{
    //聚合
    Tank tank;

    public TankTimeProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

interface Movable {
    void move();
}
