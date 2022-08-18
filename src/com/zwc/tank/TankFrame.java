package com.zwc.tank;

import java.awt.*;
import java.awt.event.*;

public class TankFrame extends Frame {
    int x = 200;
    int y = 200;

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
        x += 10;
        y += 10;
    }


    //处理键盘的监听【内部类】
    class MyKeyListener extends KeyAdapter{
        //键盘按下
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("key pressed");
        }
        //键盘抬起
        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");
        }
    }

}
