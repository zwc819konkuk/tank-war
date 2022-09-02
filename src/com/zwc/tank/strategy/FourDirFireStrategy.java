package com.zwc.tank.strategy;

import com.zwc.tank.*;
import com.zwc.tank.strategy.FireStrategy;

public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            new Bullet(bX, bY, dir, t.group);
        }
        if (t.group == Group.GOOD) new Thread(() -> new Audio("audios/tank_fire.wav").play()).start();

    }
}
