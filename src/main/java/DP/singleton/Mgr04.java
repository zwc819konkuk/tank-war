package DP.singleton;

/**
 * lazy loading + 锁
 * 虽然达到了按需初始化的目的，但是带来了线程不安全的问题
 * 在执行创建对象的部分加了synchronized代码块 线程还是不安全
 */

public class Mgr04 {
    private static Mgr04 INSTANCE;

    //私有化构造方法
    private Mgr04() {
    }

    public static  Mgr04 getInstance() {
        if (INSTANCE == null) {
            synchronized (Mgr04.class){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Mgr04();
            }
        }
        return INSTANCE;
    }

    public static  void main(String[] args) {
        /*
            如果哈希码不同说明获取的不是同一个类的同一个对象，出现了多线程访问的不安全问题
         */
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Mgr04.getInstance().hashCode())).start();
        }
    }

}
