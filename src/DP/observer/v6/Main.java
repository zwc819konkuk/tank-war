package DP.observer.v6;

import java.util.ArrayList;
import java.util.List;

/*
加入多个观察者
 */
class Child {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();

    //初始块（非静态代码块）总是和构造方法是一家子，会一块出现
    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }

    public boolean isCrying() {
        return cry;
    }

    public void wakeUp() {
        cry = true;

        wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(), "bed");

        for (Observer observer : observers) {
            observer.actionOnWakingUp(event);
        }
    }
}

//事件本身
class wakeUpEvent{
    long timestamp;//啥时候哭
    String loc;//在哪哭

    public wakeUpEvent(long timestamp, String loc) {
        this.timestamp = timestamp;
        this.loc = loc;
    }
}

interface Observer{
    void actionOnWakingUp(wakeUpEvent event);
}

class Dad implements Observer{
    public void feed() {
        System.out.println("dad feeding");
    }

    @Override
    public void actionOnWakingUp(wakeUpEvent event) {
        feed();
    }
}

class Mum implements Observer{
    public void hug() {
        System.out.println("mum hugging");
    }

    @Override
    public void actionOnWakingUp(wakeUpEvent event) {
        hug();
    }
}

class Dog implements Observer{
    public void wang() {
        System.out.println("dog wang");
    }

    @Override
    public void actionOnWakingUp(wakeUpEvent event) {
        wang();
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
