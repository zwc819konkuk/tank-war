package com.zwc.tank;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 5;
    private static final int WIDTH = 10, HEIGHT = 10 ;

    private int x,y;
    private Dir dir;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Bullet() {
    }

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, HEIGHT); //正方形的左上角坐标和宽高
        g.setColor(color);
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
    }
}
