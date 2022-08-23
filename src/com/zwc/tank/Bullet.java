package com.zwc.tank;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 10;
    public static final int WIDTH = ResourceManager.bulletD.getWidth();
    public static final int HEIGHT = ResourceManager.bulletD.getHeight();

    private int x, y;
    private Dir dir;

    private boolean living = true;
    TankFrame tf = null;


    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public Bullet() {
    }

    public void paint(Graphics g) {
        if (!living) {
            tf.bullets.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceManager.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceManager.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.bulletD, x, y, null);
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
            living = false;

    }

    public void collideWith(Tank tank) {
        Rectangle rectBu = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
        Rectangle rectTa = new Rectangle(tank.getX(), tank.getY(), tank.WIDTH, tank.HEIGHT);
        if (rectBu.intersects(rectTa)){
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.living = false;
    }
}
