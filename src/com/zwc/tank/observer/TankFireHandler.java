package com.zwc.tank.observer;

import com.zwc.tank.Tank;

public class TankFireHandler implements TankFireObserver {
    @Override
    public void actionOnFire(TankFireEvent tankFireEvent) {
        Tank tank = tankFireEvent.getSource();
        tank.fire();
    }
}
