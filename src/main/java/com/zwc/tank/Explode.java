package com.zwc.tank;

import java.awt.*;

public class Explode {
    public static final int WIDTH = ResourceManager.explodes[0].getWidth();
    public static final int HEIGHT = ResourceManager.explodes[0].getHeight();

    private int x, y;

    //    private boolean living = true;
    TankFrame tf = null;

    private int step = 0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;

        new Thread(() -> new Audio("audios/explode.wav").play()).start();

    }


    public void paint(Graphics g) {
        g.drawImage(ResourceManager.explodes[step++], x, y, null);
        if (step >= ResourceManager.explodes.length)
            tf.explodes.remove(this);


    }

}
