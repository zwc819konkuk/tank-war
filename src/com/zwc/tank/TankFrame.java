package com.zwc.tank;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {

    GameModel gm = new GameModel();



    static final int GAME_WIDTH = PropertyManager.getInt("gameWidth"), GAME_HEIGHT = PropertyManager.getInt("gameHeight");

    public TankFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

        //键盘事件的监听
        this.addKeyListener(new MyKeyListener());
        //窗口事件的监听
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    /*
        窗口需要重新绘制的时候调用
        Graphics g：系统给的画笔
    */
    @Override
    public void paint(Graphics g) {
        gm.paint(g);
    }


    //处理键盘的监听【内部类】
    class MyKeyListener extends KeyAdapter {

        //坦克的方向，坦克的坐标
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;


        //键盘按下
        @Override
        public void keyPressed(KeyEvent e) {
            //x+=200;
            //需要重新载入画布
            //repaint();

            //识别按下去的键
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
            new Thread(()->new Audio("audios/tank_move.wav").play()).start();
        }

        //键盘抬起
        @Override
        public void keyReleased(KeyEvent e) {

            //按下去的键归位
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    gm.getMainTank().fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {

            Tank myTank = gm.getMainTank();

            if (!bL && !bU && !bR && !bD) {
                myTank.setMoving(false);
            } else {

                myTank.setMoving(true);

                if (bL) myTank.setDir(Dir.LEFT);
                if (bU) myTank.setDir(Dir.UP);
                if (bR) myTank.setDir(Dir.RIGHT);
                if (bD) myTank.setDir(Dir.DOWN);
            }
        }
    }

}
