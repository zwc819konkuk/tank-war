package DP.proxy.spring.v1;

import java.util.Random;

public class Tank {
    public void move() {
        System.out.println("tank moving");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
