package com.zwc.tank.abstractfactory;

import com.zwc.tank.*;

import java.awt.*;
import java.util.Random;

public class RectTank extends BaseTank {
    int x, y;


    public Dir dir = Dir.DOWN;
    private static final int SPEED = PropertyManager.getInt("tankSpeed");

    public static final int WIDTH = ResourceManager.goodTankU.getWidth();
    public static final int HEIGHT = ResourceManager.goodTankU.getHeight();

    private Random random = new Random();

    private boolean moving = true;
    TankFrame tf = null;
    private boolean living = true;

    Group group = Group.BAD;

    public Rectangle rect = new Rectangle();

    FireStrategy fs;

    public RectTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        if (group == Group.GOOD) {
            String goodFSName = (String) PropertyManager.get("goodFS");
            try {
                fs = (FireStrategy) Class.forName(goodFSName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String badFS = (String) PropertyManager.get("badFS");
            try {
                fs = (FireStrategy) Class.forName(badFS).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g) {

        if (!living) tf.tanks.remove(this);

        Color c = g.getColor();
        g.setColor(group==Group.GOOD?Color.CYAN:Color.RED);
        g.fillRect(x,y,40,40);
        g.setColor(c);
        move();

    }

    private void move() {
        if (!moving) return;

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


        if (this.group == Group.BAD && random.nextInt(100) > 95)
            this.fire();
        if (this.group == Group.BAD && random.nextInt(100) > 95)
            randomDir();

        //边界检测不让tank出去窗口
        boundCheck();

        //更新rect
        rect.x = this.x;
        rect.y = this.y;

    }

    private void boundCheck() {
        if (this.x < 0) x = 0;
        if (this.y < 28) y = 28;
        if (this.x > TankFrame.GAME_WIDTH - RectTank.WIDTH - 2) x = TankFrame.GAME_WIDTH - RectTank.WIDTH - 2;
        if (this.y > TankFrame.GAME_HEIGHT - RectTank.HEIGHT - 2) y = TankFrame.GAME_HEIGHT - RectTank.HEIGHT - 2;

    }

    private void randomDir() {

        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            this.tf.gf.createBullet(bX, bY, dir, this.group, this.tf);
        }
        if (this.group == Group.GOOD) new Thread(() -> new Audio("audios/tank_fire.wav").play()).start();
    }

    public void die() {
        this.living = false;
    }
}
