package DP.singleton;

/**
 * 双重检查
 */

public class Mgr05 {
    private static volatile Mgr05 INSTANCE;//JIT 指令重排的问题

    //私有化构造方法
    private Mgr05() {
    }

    public static Mgr05 getInstance() {
        if (INSTANCE == null) {
            synchronized (Mgr05.class){
                if (INSTANCE ==null){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr05();
                }

            }
        }
        return INSTANCE;
    }

    public static  void main(String[] args) {
        /*
            如果哈希码不同说明获取的不是同一个类的同一个对象，出现了多线程访问的不安全问题
         */
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Mgr05.getInstance().hashCode())).start();
        }
    }

}
