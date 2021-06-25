package cn.maxiaot.singleton;

/**
 * 懒汉式（线程不安全）
 */
public class Singleton_02 {

    private Singleton_02() {}

    private static Singleton_02 instance;

    public static Singleton_02 getInstance() {
        if(null != instance) {
            return instance;
        }
        instance = new Singleton_02();
        return instance;
    }
}
