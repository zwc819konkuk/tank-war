package DP.abstractfactory;

import DP.factorymethod.CarFactory;
import DP.factorymethod.Moveable;

public class Main {
    public static void main(String[] args) {
//        Car car = new Car();
//        car.go();
//        AK47 ak47 = new AK47();
//        ak47.shoot();
//        Bread bread = new Bread();
//        bread.printName();
        AbstractFactory factory = new ModernFactory();
        Vehicle vehicle = factory.createVehicle();
        vehicle.go();
        Weapon weapon = factory.createWeapon();
        weapon.shoot();
        Food food = factory.createFood();
        food.printName();
    }
}
