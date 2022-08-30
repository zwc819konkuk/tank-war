package DP.singleton;

/**
 * 不仅可以解决线程同步还可以防止反序列化
 * 枚举单例
 */

public enum Mgr07 {

    INSTANCE;

    public static void main(String[] args) {
        /*
            如果哈希码不同说明获取的不是同一个类的同一个对象，出现了多线程访问的不安全问题
         */
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr07.INSTANCE.hashCode())).start();
        }
    }
}
