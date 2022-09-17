package DP.proxy.v7;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * 我想记录坦克的移动时间
 * 如果无法改变方法源码？
 * 使用继承？耦合度太高了
 * v3:使用代理[聚合]
 * v4:代理各种类型
 * 如何实现代理的各种组合？继承？decorator？
 * v5：静态代理
 * 如果想让logProxy也可以代理别的object的话？
 * 分离代理行为和被代理对象
 * v6:java动态代理
 */
public class Tank implements Movable {
    @Override
    public void move() {
        System.out.println("tank moving");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();

        //reflection：通过二进制字节码分析类的属性和方法
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class},
                new LogHandler(tank)
        );
        m.move();
    }
}

//方法调用时的处理程序
class LogHandler implements InvocationHandler {
    //聚合
    Tank tank;

    public LogHandler(Tank tank) {
        this.tank = tank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method " + method.getName() + " start...");
        Object o = method.invoke(tank, args);
        System.out.println("method " + method.getName() + " end...");
        return o;
    }
}

interface Movable {
    void move();
}
