package DP.factorymethod;

/**
 * 简单工厂的可扩展性不好
 */
public class VehicleSimpleFactory {
    public Car createCar(){
        //前面加日志权限等前置操作
        return new Car();
    }

    public plane createPlane(){
        //前面加日志权限等前置操作
        return new plane();
    }
}
