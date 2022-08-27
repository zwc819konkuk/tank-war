package DP.singleton;

/**
 *饿汉式
 * 类加载到内存之后就实例化一个单例，JVM保证线程安全
 * 简单实用
 * 唯一缺点：不管用到与否，类加载时就完成实例化
 */

public class Mgr01 {
    private static final Mgr01 INSTANCE = new Mgr01();

    //私有化构造方法
    private Mgr01() {
    }

    public static Mgr01 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Mgr01 mgr01 = Mgr01.getInstance();
        Mgr01 mgr02 = Mgr01.getInstance();
        System.out.println(mgr01==mgr02);
    }

}
