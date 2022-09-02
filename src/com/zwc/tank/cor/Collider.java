package com.zwc.tank.cor;

import com.zwc.tank.GameObject;

/**
 * 两个游戏物体间的碰撞
 */
public interface Collider {
    boolean collide(GameObject o1,GameObject o2);
}
