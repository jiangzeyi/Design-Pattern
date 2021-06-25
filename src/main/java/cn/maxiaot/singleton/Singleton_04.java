package cn.maxiaot.singleton;

/**
 * 双重检查锁
 */
public class Singleton_04 {

    private Singleton_04() {}

    private static Singleton_04 instance;

    public static Singleton_04 getInstance() {
        if(null != instance) {
            return instance;
        }
        synchronized (Singleton_04.class) {
            if(null == instance) {
                instance = new Singleton_04();
            }
        }
        return instance;
    }
}
