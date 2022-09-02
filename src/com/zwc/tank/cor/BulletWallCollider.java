package com.zwc.tank.cor;

import com.zwc.tank.Bullet;
import com.zwc.tank.GameObject;
import com.zwc.tank.Tank;
import com.zwc.tank.Wall;

public class BulletWallCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall){
            Bullet b = (Bullet)o1;
            Wall w = (Wall) o2;
            if (b.rect.intersects(w.rect)){
                b.die();
            }
        }else if (o2 instanceof Bullet && o1 instanceof Wall){
            return collide(o2,o1);
        }
        return true;
    }
}
