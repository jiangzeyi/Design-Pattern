package cn.maxiaot.singleton;

/**
 * 懒汉式（线程安全）
 */
public class Singleton_03 {

    private Singleton_03() {}

    private static Singleton_03 instance;

    public static synchronized Singleton_03 getInstance() {
        if(null != instance) {
            return instance;
        }
        instance = new Singleton_03();
        return instance;
    }
}
