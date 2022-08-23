package com.zwc.tank;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 5;
    private static final int WIDTH = 10, HEIGHT = 10;

    private int x, y;
    private Dir dir;

    private boolean live = true;
    TankFrame tf = null;

    public Bullet(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public Bullet() {
    }

    public void paint(Graphics g) {
        if (!live){
            tf.bullets.remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(ResourceManager.bulletL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceManager.bulletU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.bulletR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.bulletD,x,y,null);
                break;
        }
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT)
            live = false;

    }
}
