package com.zwc.tank.decorator;

import com.zwc.tank.GameModel;
import com.zwc.tank.GameObject;

import java.awt.*;

public abstract class GODecorator extends GameObject {

    GameObject go;

    public GODecorator(GameObject go){

        this.go = go;
    }

    @Override
    public abstract void paint(Graphics g);

}
