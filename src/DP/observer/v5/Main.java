package DP.observer.v5;

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
        for (Observer observer : observers) {
            observer.actionOnWakingUp();
        }
    }
}

interface Observer{
    void actionOnWakingUp();
}

class Dad implements Observer{
    public void feed() {
        System.out.println("dad feeding");
    }

    @Override
    public void actionOnWakingUp() {
        feed();
    }
}

class Mum implements Observer{
    public void hug() {
        System.out.println("mum hugging");
    }

    @Override
    public void actionOnWakingUp() {
        hug();
    }
}

class Dog implements Observer{
    public void wang() {
        System.out.println("dog wang");
    }

    @Override
    public void actionOnWakingUp() {
        wang();
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
