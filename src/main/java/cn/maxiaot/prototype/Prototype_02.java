package cn.maxiaot.prototype;

import java.io.*;
import java.util.Date;

/**
 * 通过序列化反序列化实现克隆
 */
public class Prototype_02 implements Serializable {

    private String fullName;

    private int age;

    private Date date;

    @Override
    protected Object clone() throws CloneNotSupportedException {

        try {
            ByteArrayOutputStream byteArrayOutputStream =  new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Prototype_02 instance = (Prototype_02) objectInputStream.readObject();
            return instance;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
