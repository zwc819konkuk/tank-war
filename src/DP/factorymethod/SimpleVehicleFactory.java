package DP.factorymethod;

/**
 * 简单工厂
 * 可扩展性不好
 */
public class SimpleVehicleFactory {
    public Car createCar(){
        return new Car();
    }

    public Plane createPlane(){
        return new Plane();
    }

    public Broom createBroom(){
        return new Broom();
    }
}
