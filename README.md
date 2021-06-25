# Design Pattern
> **设计模式**（design pattern）是对软件设计中普遍存在（反复出现）的各种问题，所提出的解决方案。
>
> — 维基百科

设计模式大致分为三种类型，一共有23种。

- **创建型**：[工厂模式](#工厂模式)、[抽象工厂模式](#抽象工厂模式)、[单例模式](#单例模式)、原型模式、建造者模式
- **结构型**：适配器模式、桥接模式、组合模式、装饰器模式、外观模式、享元模式、代理模式
- **行为型**：责任连模式、命令模式、解释器模式、迭代器模式、中介者模式、备忘录模式、观察者模式、状态模式、策略模式、模板方法模式、访问者模式

## 工厂模式

> 普通的工厂方法模式通常伴随着对象的具体类型与工厂具体类型的一一对应，客户端代码根据需要选择合适的具体类型工厂使用。
>
> — 维基百科

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

> **抽象工厂模式**（英语：**Abstract factory pattern**）是一种软件开发设计模式。抽象工厂模式提供了一种方式，可以将一组具有同一主题的单独的工厂封装起来。在正常使用中，客户端程序需要创建抽象工厂的具体实现，然后使用抽象工厂作为接口来创建这一主题的具体对象。
>
> — 维基百科

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

> **单例模式**，是一种常用的软件设计模式，属于创建型模式的一种。在应用这个模式时，单例对象的类必须保证只有一个实例存在。许多时候整个系统只需要拥有一个的全局对象，这样有利于我们协调系统整体的行为
>
> — 维基百科

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

