package DP.abstractfactory;

public class Main {
    public static void main(String[] args) {
//        AbstractFactory f = new EarthFactory();
        AbstractFactory f = new MarsFactory();

        f.createFood().printName();
        f.createWeapon().shoot();
        f.createVehicle().go();
    }
}
