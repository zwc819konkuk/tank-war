package com.zwc.tank.abstractfactory;

import com.zwc.tank.Group;

import java.awt.*;

public abstract class BaseTank {
    public static Rectangle rect = new Rectangle();
    public Group group = Group.BAD;

    public  Group getGroup() {
        return this.group;
    }

    public abstract void paint(Graphics g);

    public abstract void die();

    public abstract int getX();

    public abstract int getY();
}
