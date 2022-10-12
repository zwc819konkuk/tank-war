package DP.abstractfactory;
/**
 * Mars's factory
 */
public class MarsFactory extends AbstractFactory{
    /**
     * create food for Mars
     * @return
     */
    @Override
    Food createFood() {
        return new MushRoom();
    }

    /**
     * create vehicle for Mars
     * @return
     */
    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    /**
     * create weapon for Mars
     * @return
     */
    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
