package DP.factorymethod;

public class CarFactory {
    public Car createCar() {
        System.out.println("a car is created");
        return new Car();
    }
}
