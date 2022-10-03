package com.zwc.tank.strategy;

import com.zwc.tank.Tank;

import java.io.Serializable;

public interface FireStrategy extends Serializable {
    void fire(Tank t);
}
