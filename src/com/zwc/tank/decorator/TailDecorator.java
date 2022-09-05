package com.zwc.tank.decorator;

import com.zwc.tank.GameObject;

import java.awt.*;

public class TailDecorator extends GODecorator{
    public TailDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;
        go.paint(g);
        //加个方框
        Color c=g.getColor();
        g.setColor(Color.WHITE);
        g.drawLine(go.x,go.y,go.x+getWidth(),go.y+getHeight());
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return super.go.getWidth();
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();
    }
}
