# Design Pattern

## 六大原则

- 单一职责原则：一个类有且只有一个改变类的原因
- 开闭原则：对扩展开放，修改关闭
- 里氏替换原则：子类可以在程序中替换父类对象
- 迪米特法则原则：有内在关联的类要内聚，没直接关系的类要低耦合
- 接口隔离原则：一个类对另一个类的依赖应该建立在最小接口上
- 依赖倒置原则：高层模块不应该依赖于底层模块，两者都应依赖与抽象。抽象不应依赖细节，细节应依赖抽象



> **设计模式**（design pattern）是对软件设计中普遍存在（反复出现）的各种问题，所提出的解决方案。
>
> — 维基百科

设计模式大致分为三种类型，一共有23种。

- **创建型**：[工厂模式](#工厂模式)、[抽象工厂模式](#抽象工厂模式)、[单例模式](#单例模式)、[原型模式](#原型模式)、[建造者模式](#建造者模式)
- **结构型**：适配器模式、桥接模式、组合模式、装饰器模式、外观模式、享元模式、代理模式
- **行为型**：责任连模式、命令模式、解释器模式、迭代器模式、中介者模式、备忘录模式、观察者模式、状态模式、策略模式、模板方法模式、访问者模式

## 工厂模式

> 普通的工厂方法模式通常伴随着对象的具体类型与工厂具体类型的一一对应，客户端代码根据需要选择合适的具体类型工厂使用。— 维基百科

数学中图形周长计算。众所周知图形有成千上百种。

周长计算程序类图（PlantUml 生成）

![simple factory](https://github.com/maxiaot/Design-Pattern/blob/main/img/simple%20factory.png)

计算周长接口

```
public interface PerimeterCalculator {

    double perimeterCalculator(double n);
}
```

正方形周长计算

```java
public class SquarePerimeterCalculator implements PerimeterCalculator {

    @Override
    public double perimeterCalculator(double n) {
        BigDecimal bigDecimal = new BigDecimal(n * 4);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
```

圆形周长计算

```java
public class CirclePerimeterCalculator implements PerimeterCalculator {

    private static final double PI = 3.14;

    @Override
    public double perimeterCalculator(double n) {
        BigDecimal bigDecimal = new BigDecimal(2 * PI * n);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
```

周长计算工厂

```java
public class PerimeterCalculatorFactory {

    public static PerimeterCalculator perimeterCalculator(String graph) {
        if("Square".equals(graph)) {
            return new SquarePerimeterCalculator();
        }
        if ("Circle".equals(graph)) {
            return new CirclePerimeterCalculator();
        }
        return null;
    }
}
```



## 抽象工厂模式

> **抽象工厂模式**（英语：**Abstract factory pattern**）是一种软件开发设计模式。抽象工厂模式提供了一种方式，可以将一组具有同一主题的单独的工厂封装起来。在正常使用中，客户端程序需要创建抽象工厂的具体实现，然后使用抽象工厂作为接口来创建这一主题的具体对象。— 维基百科

工厂模式能帮我们解决创建一种类型的对象。我们要实现计算周长和计算面积，工厂模式就难搞咯😣

抽象工厂模式用于多个产品族。计算周长和计算面积刚好是多个产品族，使用抽象工厂最合适😀

计算周长接口

```java
public interface PerimeterCalculator {

    double perimeterCalculator(double n);
}
```

正方形周长计算

```java
public class SquarePerimeterCalculator implements PerimeterCalculator {

    @Override
    public double perimeterCalculator(double n) {
        BigDecimal bigDecimal = new BigDecimal(n * 4);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
```

圆形周长计算

```java
public class CirclePerimeterCalculator implements PerimeterCalculator {

    private static final double PI = 3.14;

    @Override
    public double perimeterCalculator(double n) {
        BigDecimal bigDecimal = new BigDecimal(2 * PI * n);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
```

计算面积接口

```java
public interface AreaCalculator {
    
    double areaCalculate(double n);
}
```

正方形面积计算

```java
public class SquareAreaCalculator implements AreaCalculator {

    @Override
    public double areaCalculate(double n) {
        BigDecimal bigDecimal = new BigDecimal(n * n);
        return bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
```

圆形面积计算

```java
public class CircleAreaCalculator implements AreaCalculator {

    private static final double PI = 3.14;

    @Override
    public double areaCalculate(double n) {
        BigDecimal bigDecimal = new BigDecimal(PI * n * n);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
```

计算工厂

```java
public class CalculatorFactory {

    public static PerimeterCalculatorFactory perimeterCalculatorFactory() {
        return new PerimeterCalculatorFactory();
    }

    public static AreaCalculatorFacotry areaCalculatorFacotry() {
        return new AreaCalculatorFacotry();
    }
}
```

周长计算工厂

```java
public class PerimeterCalculatorFactory {

    public PerimeterCalculator createSquareCalculateInstance() {
        return new SquarePerimeterCalculator();
    }

    public PerimeterCalculator createCircleCalculateInstance() {
        return new CirclePerimeterCalculator();
    }
}
```

面积计算工厂

```java
public class AreaCalculatorFacotry {

    public AreaCalculator createSquareCalculateInstance() {
        return new SquareAreaCalculator();
    }

    public AreaCalculator createCircleCalculateInstance() {
        return new CircleAreaCalculator();
    }
}
```

## 单例模式

> **单例模式**，是一种常用的软件设计模式，属于创建型模式的一种。在应用这个模式时，单例对象的类必须保证只有一个实例存在。许多时候整个系统只需要拥有一个的全局对象，这样有利于我们协调系统整体的行 — 维基百科

**饿汉式**

```java
public class Singleton_01 {

    private Singleton_01() {}

    private static Singleton_01 instance = new Singleton_01();

    public static Singleton_01 getInstance() {
        return instance;
    }

}
```

该方式唯一的缺点就是浪费内存，但你觉得这个类用不上吗😏

**懒汉式（线程不安全）**

```java
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
```

该方式实现了懒加载。两个线程同时请求时可能会生成两个对象，是线程不安全的。

**懒汉式（线程安全）**

```java
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
```

实现跟上面那种懒汉式极其相似。只是在方法上加了锁，加了锁一定是线程安全的吗？那可不确定。

**双重检查锁**

```java
public class Singleton_04 {

    private Singleton_04() {}

    private static volatile Singleton_04 instance;

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
```

该方法缩小了锁的粒度并使用了 volatile 保证线程对变量的可见性，同时在获取实例时进行了双重检查防止对象重复实例化。

**静态内部类**

```java
public class Singleton_05 {

    private Singleton_05() {}

    private static class Singleton {
        private static Singleton_05 instance = new Singleton_05();
    }

    public static Singleton_05 getInstance() {
        return Singleton.instance;
    }
}
```

静态内部类是通过 JVM 加载机制来实现的。它是线程安全的，工作中推荐使用。

**枚举**

单元素枚举成为单例最好的实现方式，在日常编码中不常用就不多做解释。

## 原型模式

> **原型模式**是创建型模式的一种，其特点在于通过“复制”一个已经存在的实例来返回新的实例,而不是新建实例。被复制的实例就是我们所称的“原型”，这个原型是可定制的。— 维基百科

原型模式广泛运用在创建复杂或耗时的实例。这些情况下，复制一个已有的实例使程序运行更高效。

**重写 clone 方法**

```java
public class Prototype_01 implements Cloneable {

    private String fullName;

    private int age;

    private Date createDate;
    
    // 省略 getter/setter 方法
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Prototype_01)super.clone();
    }
    
}
```

**序列化反序列化**

```java
 public class Prototype_02 implements Serializable {

    private String fullName;

    private int age;

    private Date date;
    
    // 省略 getter/setter 方法

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
```

**浅克隆和深克隆**

浅克隆只复制基本类型的数据，引用类型只复制了引用的地址值，并没有产生一个新对象

深克隆复制后的对象与原对象互不影响

实现深克隆的方式：需要克隆的引用类型重写 clone 方法、使用序列化和反序列化

## 建造者模式

> 建造者模式，是一种对象构建模式。它可以将复杂对象的建造过程抽象出来（抽象类别），使这个抽象过程的不同实现方法可以构造出不同表现（属性）的对象。— 维基百科

使用建造者模式创建披萨

披萨实体

```java
public class Pazz {

    private String taste;

    private String topping;
    
    // 省略 getter/setter 方法
}
```

披萨抽象 Builder

```java
public abstract class PazzBuilder {

    protected Pazz pazz;

    public PazzBuilder makePazz() {
        pazz = new Pazz();
        return this;
    }

    // 选择口味
    public abstract PazzBuilder choiceTaste();

    public abstract PazzBuilder choiceTopping();

    public Pazz build() {
        return this.pazz;
    }
}
```

榴莲口味披萨 

```java
public class DurianPazzBuilder extends PazzBuilder {

    @Override
    public PazzBuilder choiceTaste() {
        super.pazz.setTaste("原味");
        return this;
    }

    @Override
    public PazzBuilder choiceTopping() {
        super.pazz.setTopping("榴莲");
        return this;
    }
}
```

水果披萨

```java
public class FruitsPazzBuilder extends PazzBuilder {
    @Override
    public PazzBuilder choiceTaste() {
        super.pazz.setTaste("甜");
        return this;
    }

    @Override
    public PazzBuilder choiceTopping() {
        super.pazz.setTopping("水果");
        return this;
    }
}
```

服务员（通知制作披萨，并将制作好的披萨给用户）

```java
public class Waiter {

    private PazzBuilder pazzBuilder;

    public PazzBuilder getPazzBuilder() {
        return pazzBuilder;
    }

    public void setPazzBuilder(PazzBuilder pazzBuilder) {
        this.pazzBuilder = pazzBuilder;
    }

    public  Pazz makePazz() {
        return pazzBuilder.makePazz()
                .choiceTaste().choiceTopping().build();
    }
}
```

测试

```java
public class PazzBuilderExample {
    public static void main(String[] args) {
        PazzBuilder pazzBuilder = new DurianPazzBuilder();
        Waiter waiter = new Waiter();
        waiter.setPazzBuilder(pazzBuilder);
        Pazz pazz = waiter.makePazz();
        System.out.println(pazz);
    }
}
```

