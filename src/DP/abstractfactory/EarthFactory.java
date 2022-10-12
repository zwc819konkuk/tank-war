package DP.abstractfactory;

/**
 * earth's factory
 */
public class EarthFactory extends AbstractFactory{
    /**
     * create food for earth
     * @return
     */
    @Override
    Food createFood() {
        return new Bread();
    }
    /**
     * create vehicle for earth
     * @return
     */
    @Override
    Vehicle createVehicle() {
        return new Car();
    }
    /**
     * create weapon for earth
     * @return
     */
    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
