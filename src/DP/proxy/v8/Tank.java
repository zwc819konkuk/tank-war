package DP.proxy.v8;


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
 * v7:java动态代理
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
        //>JDK8
        //System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        //JDK8
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");


        //reflection：通过二进制字节码分析类的属性和方法
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class},
                new TimeHandler(tank)
        );
        m.move();
    }
}

//方法调用时的处理程序
class TimeHandler implements InvocationHandler {
    //聚合
    Movable m;

    public TimeHandler(Movable m) {
        this.m = m;
    }

    public void before() {
        System.out.println("method start...");
    }

    public void after() {
        System.out.println("method stop...");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object o = method.invoke(m, args);
        after();
        return o;
    }
}

interface Movable {
    void move();
}
