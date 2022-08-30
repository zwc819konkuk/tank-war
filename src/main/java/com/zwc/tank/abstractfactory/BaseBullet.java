package com.zwc.tank.abstractfactory;

import com.zwc.tank.Tank;

import java.awt.*;

public abstract class BaseBullet {
    public abstract void collideWith(BaseTank tank);

    public abstract void paint(Graphics g);
}
