package com.zwc.tank;

import java.awt.*;
import java.awt.event.*;

public class TankFrame extends Frame {
    int x = 200;
    int y = 200;
    Dir dir = Dir.DOWN;
    private static final int SPEED = 10;

    public TankFrame() {
        setSize(800, 600);
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

    /*
    窗口需要重新绘制的时候调用
    Graphics g：系统给的画笔
     */
    @Override
    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50); //正方形的左上角坐标和宽高
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
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (bL) dir = Dir.LEFT;
            if (bU) dir = Dir.UP;
            if (bR) dir = Dir.RIGHT;
            if (bD) dir = Dir.DOWN;
        }
    }

}
