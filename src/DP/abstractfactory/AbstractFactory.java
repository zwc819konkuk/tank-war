package DP.abstractfactory;

public abstract class AbstractFactory {
    /**
     * create food for different planet
     * @return
     */
    abstract Food createFood();
    /**
     * create vehicle for different planet
     * @return
     */
    abstract Vehicle createVehicle();
    /**
     * create weapon for different planet
     * @return
     */
    abstract Weapon createWeapon();
}
