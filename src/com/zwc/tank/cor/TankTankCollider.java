package com.zwc.tank.cor;

import com.zwc.tank.Bullet;
import com.zwc.tank.GameObject;
import com.zwc.tank.Tank;
import sun.nio.cs.FastCharsetProvider;

public class TankTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            if (t1.getRect().intersects(t2.getRect())) {
                t1.turnAround();
                t2.turnAround();
            }
        }
        return true;

    }
}
