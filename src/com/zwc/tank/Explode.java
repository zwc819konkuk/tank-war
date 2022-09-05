package com.zwc.tank;

import java.awt.*;

public class Explode extends GameObject{
    public static final int WIDTH = ResourceManager.explodes[0].getWidth();
    public static final int HEIGHT = ResourceManager.explodes[0].getHeight();

    //    private boolean living = true;

    private int step = 0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;

        new Thread(() -> new Audio("audios/explode.wav").play()).start();
        GameModel.getInstance().add(this);
    }


    public void paint(Graphics g) {
        g.drawImage(ResourceManager.explodes[step++], x, y, null);
        if (step >= ResourceManager.explodes.length)
            GameModel.getInstance().remove(this);


    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

}
