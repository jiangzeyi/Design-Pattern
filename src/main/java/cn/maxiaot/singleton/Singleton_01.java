package cn.maxiaot.singleton;

/**
 * 饿汉式
 */
public class Singleton_01 {

    private Singleton_01() {}

    private static final Singleton_01 instance = new Singleton_01();

    public static Singleton_01 getInstance() {
        return instance;
    }

}
