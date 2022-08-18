package com.zwc.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
    public static void main(String[] args) {
        Frame f = new Frame();
        f.setSize(800,600);//设置宽高
        f.setResizable(false);//设置大小是否可变
        f.setTitle("tank war");//设置标题
        f.setVisible(true);//设为可见

        //设置窗口监听器
        f.addWindowListener(new WindowAdapter() {//匿名内部类，是WindowListener的实现类
            //窗口关闭，点击左上角×
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
