package com.zwc.tank;

import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD, this);//我的坦克
    java.util.List<Bullet> bullets = new ArrayList<>();//子弹
    java.util.List<Tank> tanks = new ArrayList<>();//敌人坦克
    List<Explode> explodes = new ArrayList<>();//爆炸

    public GameModel() {
        int initTankCount = PropertyManager.getInt("initTankCount");

        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            tanks.add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, this));
        }

    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹数量" + bullets.size(), 10, 60);
        g.drawString("敌人数量" + tanks.size(), 10, 80);
        g.drawString("爆炸数量" + explodes.size(), 10, 100);
        g.setColor(c);

        myTank.paint(g);

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }

        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }

        //碰撞检测 collision detect
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));
            }
        }

    }

    public Tank getMainTank() {
        return myTank;
    }
}
