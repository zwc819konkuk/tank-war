package com.zwc.tank;

import com.zwc.tank.abstractfactory.BaseTank;

public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            t.tf.gf.createBullet(bX, bY, dir, t.group, t.tf);
        }
        if (t.group == Group.GOOD) new Thread(() -> new Audio("audios/tank_fire.wav").play()).start();

    }
}
