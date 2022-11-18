package com.zwc.tank.strategy;

import com.zwc.tank.*;
import com.zwc.tank.decorator.RectDecorator;
import com.zwc.tank.decorator.TailDecorator;

public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

        //new bullet把自己又加了一遍bug
        //两个装饰器一起使用
//        GameModel.getInstance().add(
//                new RectDecorator(
//                        new TailDecorator(new Bullet(bX, bY, t.dir, t.group))));
        new Bullet(bX,bY,t.dir,t.group);
        if (t.group == Group.GOOD) new Thread(() -> new Audio("audios/tank_fire.wav").play()).start();
    }
}
