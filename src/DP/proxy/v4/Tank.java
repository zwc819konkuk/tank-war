package DP.proxy.v4;


import java.util.Random;

/**
 * 我想记录坦克的移动时间
 * 如果无法改变方法源码？
 * 使用继承？耦合度太高了
 * v3:使用代理[聚合]
 * v4:代理各种类型
 * 如何实现代理的各种组合？继承？decorator？
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
        new TankLogProxy(new Tank()).move();
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
class TankLogProxy implements Movable{
    //聚合
    Tank tank;

    public TankLogProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        System.out.println("start moving");
        tank.move();
        System.out.println("stop!");
    }
}

interface Movable {
    void move();
}
