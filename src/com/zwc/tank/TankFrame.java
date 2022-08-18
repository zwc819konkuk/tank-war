package com.zwc.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TankFrame extends Frame {
    public TankFrame() {
        setSize(800,600);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

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
       g.fillRect(200,200,50,50); //正方形的左上角坐标和宽高
    }
}
