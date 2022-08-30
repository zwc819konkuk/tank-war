package DP.singleton;

/**
 * lazy loading
 * 虽然达到了按需初始化的目的，但是带来了线程不安全的问题
 */

public class Mgr02 {
    private static Mgr02 INSTANCE;

    //私有化构造方法
    private Mgr02() {
    }

    public static Mgr02 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr02();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        /*
            如果哈希码不同说明获取的不是同一个类的同一个对象，出现了多线程访问的不安全问题
         */
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Mgr02.getInstance().hashCode())).start();
        }
    }

}
