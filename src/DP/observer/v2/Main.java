package DP.observer.v2;

class Child {
    private boolean cry = false;

    public boolean isCrying() {
        return cry;
    }

    private void wakeUp() {
        System.out.println("wake up!");
        cry = true;
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        while (!child.isCrying()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("observing");
        }
    }
}
