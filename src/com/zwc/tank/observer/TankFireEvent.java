package com.zwc.tank.observer;

import com.zwc.tank.Tank;

public class TankFireEvent {
    Tank tank;
    public Tank getSource(){
        return tank;
    }
    public TankFireEvent(Tank tank) {
        this.tank=tank;
    }
}
