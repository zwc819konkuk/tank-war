package DP.factorymethod;

import DP.strategy.Cat;

public class Main {
    public static void main(String[] args) {
        Moveable m = new CarFactory().createCar();
        m.go();
    }
}
