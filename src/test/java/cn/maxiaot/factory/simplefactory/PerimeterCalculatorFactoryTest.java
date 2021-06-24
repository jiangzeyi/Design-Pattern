package cn.maxiaot.factory.simplefactory;

import cn.maxiaot.factory.simplefactory.calculator.PerimeterCalculator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PerimeterCalculatorFactoryTest {

    @Test
    void perimeterCalculator() {
        PerimeterCalculator circle = PerimeterCalculatorFactory.perimeterCalculator("Circle");
        double circlePerimeter = circle.perimeterCalculator(2.5);
        System.out.println("圆周长为：" + circlePerimeter);
        PerimeterCalculator square = PerimeterCalculatorFactory.perimeterCalculator("Square");
        double squarePerimeter = square.perimeterCalculator(2.5);
        System.out.println("正方形周长为：" + squarePerimeter);
    }

}