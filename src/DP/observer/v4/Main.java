package DP.observer.v4;

/*
加入多个观察者
 */
class Child {
    private boolean cry = false;
    private Dad d = new Dad();
    private Mum m = new Mum();
    private Dog dog = new Dog();

    public boolean isCrying() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        d.feed();
        m.hug();
        dog.wang();
    }
}

class Dad {
    public void feed() {
        System.out.println("dad feeding");
    }
}
class Mum {
    public void hug() {
        System.out.println("mum hugging");
    }
}
class Dog {
    public void wang() {
        System.out.println("dog wang");
    }
}
public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
