package cn.maxiaot.prototype;

import java.util.Date;

/**
 * 通过重写 clone 方法实现克隆
 */
public class Prototype_01 implements Cloneable {

    private String fullName;

    private int age;

    private Date createDate;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Prototype_01)super.clone();
    }

}
