package com.zwc.tank.cor;

import com.zwc.tank.Bullet;
import com.zwc.tank.GameObject;
import com.zwc.tank.Tank;
import com.zwc.tank.Wall;

public class TankWallCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall){
            Tank t = (Tank) o1;
            Wall w = (Wall) o2;
            if (t.rect.intersects(w.rect)){
                t.back();
            }
        }else if (o2 instanceof Tank && o1 instanceof Wall){
            return collide(o2,o1);
        }
        return true;
    }
}
