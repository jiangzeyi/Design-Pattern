# Design Pattern
> **设计模式**（design pattern）是对软件设计中普遍存在（反复出现）的各种问题，所提出的解决方案。
>
> — 维基百科

设计模式大致分为三种类型，一共有23种。

- **创建型**：工厂模式、抽象工厂模式、单例模式、原型模式、建造者模式
- **结构型**：适配器模式、桥接模式、组合模式、装饰器模式、外观模式、享元模式、代理模式
- **行为型**：责任连模式、命令模式、解释器模式、迭代器模式、中介者模式、备忘录模式、观察者模式、状态模式、策略模式、模板方法模式、访问者模式

## 工厂模式

> 普通的工厂方法模式通常伴随着对象的具体类型与工厂具体类型的一一对应，客户端代码根据需要选择合适的具体类型工厂使用。
>
> — 维基百科

数学中图形周长计算。众所周知图形有成千上百种。

计算周长接口

```
public interface PerimeterCalculator {

    double perimeterCalculator(double n);
}
```

正方形周长计算

```java
public class SquarePerimeterCalculator implements PerimeterCalculator {

    /**
     * 计算正方形周长
     * @param n 边长
     * @return 正方形周长
     */
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

    // 圆周率
    private static final double PI = 3.14;
    /**
     * 计算圆周长
     * @param n 圆半径
     * @return 圆周长
     */
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

工厂模式能帮我们解决创建一种类型的对象。我们要实现计算周长和计算面积，工厂模式就难搞咯😣。

抽象工厂模式用于多个产品族。计算周长和计算面积刚好是多个产品族，使用抽象工厂最合适😀。

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

