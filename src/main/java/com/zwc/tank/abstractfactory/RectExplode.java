package com.zwc.tank.abstractfactory;

import com.zwc.tank.Audio;
import com.zwc.tank.ResourceManager;
import com.zwc.tank.TankFrame;

import java.awt.*;

public class RectExplode extends BaseExplode {
    public static final int WIDTH = ResourceManager.explodes[0].getWidth();
    public static final int HEIGHT = ResourceManager.explodes[0].getHeight();

    private int x, y;

    //    private boolean living = true;
    TankFrame tf = null;

    private int step = 0;

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;

        new Thread(() -> new Audio("audios/explode.wav").play()).start();

    }

    @Override
    public void paint(Graphics g) {
        //g.drawImage(ResourceManager.explodes[step++], x, y, null);
        Color c  = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x,y,10*step,10*step);
        step++;
        if (step >= 5)
            tf.explodes.remove(this);

        g.setColor(c);
    }
}
