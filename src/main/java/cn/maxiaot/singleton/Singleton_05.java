package cn.maxiaot.singleton;

/**
 * 静态内部类（线程安全）
 */
public class Singleton_05 {

    private Singleton_05() {}

    private static class Singleton {
        private static final Singleton_05 instance = new Singleton_05();
    }

    public static Singleton_05 getInstance() {
        return Singleton.instance;
    }
}
