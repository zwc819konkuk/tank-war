package com.zwc.tank.abstractfactory;

import com.zwc.tank.*;

public class DefaultFactory extends GameFactory{
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Tank(x,y,dir,group,tf);
    }

    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new Explode(x,y,tf);
    }

    public BaseBullet createBullet(int x, int y,Dir dir,Group group, TankFrame tf) {
        return new Bullet(x,y,dir,group,tf);
    }
}
