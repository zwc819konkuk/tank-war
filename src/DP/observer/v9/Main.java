package DP.observer.v9;

import java.util.ArrayList;
import java.util.List;

/*
    When handling events, you need the event source object
    Events can also form an inheritance system
    When the event happens (when the child wakes up and cries), the observers (dad, mum, dog) react
 */
class Child {
    private boolean cry = false;
    //observer list
    private List<Observer> observers = new ArrayList<>();

    //Non-static block of code，Executed with the constructor is called
    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }

    //哭Determine if the child is crying
    public boolean isCrying() {
        return cry;
    }

    public void wakeUp() {
        //Children cry when they wake up
        cry = true;
        //Create the Wakeup event, pass in the time and place of wakeup, and the object to execute the event
        wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(), "bed", this);
        //Each observer responded separately
        for (Observer observer : observers) {
            observer.actionOnWakingUp(event);
        }
    }
}

abstract class Event<T>{
    //Event source, that is, on which object the event occurred
    abstract T getSource();
}

//Wakeup event. There could be other events
class wakeUpEvent extends Event<Child>{
    long timestamp;//What time to cry
    String loc;//where to cry
    Child source;//who made this event

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
    //Responding to wakeup can extend the response to other events
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
