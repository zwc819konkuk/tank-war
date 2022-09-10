package DP.observer.v8;

import java.util.ArrayList;
import java.util.List;

/*
    处理事件的时候，需要事件源对象
    事件也可以形成继承体系
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

        wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(), "bed", this);

        for (Observer observer : observers) {
            observer.actionOnWakingUp(event);
        }
    }
}

abstract class Event<T>{
    abstract T getSource();
}

//事件本身
class wakeUpEvent extends Event<Child>{
    long timestamp;//啥时候哭
    String loc;//在哪哭
    Child source;//谁产生的事件

    public wakeUpEvent(long timestamp, String loc, Child source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }

    @Override
    Child getSource() {
        return source;
    }
}

interface Observer {
    void actionOnWakingUp(wakeUpEvent event);
}

class Dad implements Observer {
    public void feed() {
        System.out.println("dad feeding");
    }

    @Override
    public void actionOnWakingUp(wakeUpEvent event) {
        feed();
    }
}

class Mum implements Observer {
    public void hug() {
        System.out.println("mum hugging");
    }

    @Override
    public void actionOnWakingUp(wakeUpEvent event) {
        hug();
    }
}

class Dog implements Observer {
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
