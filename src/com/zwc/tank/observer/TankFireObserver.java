package com.zwc.tank.observer;

import java.io.Serializable;

public interface TankFireObserver extends Serializable {
    void actionOnFire(TankFireEvent tankFireEvent);
}
