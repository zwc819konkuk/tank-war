package com.zwc.tank;

import java.awt.*;

public abstract class GameObject {
    public int x,y;

    public abstract void paint(Graphics g);
    public abstract int getWidth();
    public abstract int getHeight();
}
