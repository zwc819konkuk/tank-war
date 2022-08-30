package com.zwc.tank.abstractfactory;

import com.zwc.tank.*;

import java.awt.*;

public class RectBullet extends BaseBullet {
    private static final int SPEED = PropertyManager.getInt("bulletSpeed");
    public static final int WIDTH = ResourceManager.bulletD.getWidth();
    public static final int HEIGHT = ResourceManager.bulletD.getHeight();

    Rectangle rect = new Rectangle();

    private int x, y;
    private Dir dir;

    private boolean living = true;
    TankFrame tf = null;
    private Group group = Group.BAD;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public RectBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        tf.bullets.add(this);
    }

    public RectBullet() {
    }

    public void paint(Graphics g) {
        if (!living) {
            tf.bullets.remove(this);
        }
        Color c = g.getColor();
        g.setColor(Color.BLUE);
        g.fillRect(x,y,20,20);
        g.setColor(c);
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

        //更新rect
        rect.x = this.x;
        rect.y = this.y;

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT)
            living = false;

    }

    //碰撞检测
    public void collideWith(BaseTank tank) {
        if (this.group == tank.getGroup()) return;
        if (rect.intersects(tank.rect)) {
            tank.die();
            this.die();
            int eX = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
            int eY = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
            tf.explodes.add(tf.gf.createExplode(eX, eY, tf));
        }
    }

    private void die() {
        this.living = false;
    }
}
