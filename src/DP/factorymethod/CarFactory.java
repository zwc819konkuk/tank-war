package DP.factorymethod;

public class CarFactory {
    public Moveable createCar() {
        System.out.println("a car created!");
        return new Car();
    }
}
