package DP.singleton;

/**
 * 静态内部类
 * JVM保证单例
 * 加载外部类时不会加载内部类，只有在调用getInstance的时候才会加载内部类，内部类实例化对象，这样实现了懒加载
 */

public class Mgr06 {

    //私有化构造方法
    private Mgr06() {
    }

    //静态内部类初始化外部类对象
    private static class Mgr06Holder {
        private static Mgr06 INSTANCE = new Mgr06();
    }

    public static Mgr06 getInstance() {
        return Mgr06Holder.INSTANCE;
    }

    public static void main(String[] args) {
        /*
            如果哈希码不同说明获取的不是同一个类的同一个对象，出现了多线程访问的不安全问题
         */
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr06.getInstance().hashCode())).start();
        }
    }

}
