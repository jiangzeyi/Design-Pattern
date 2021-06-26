package cn.maxiaot.factory.simplefactory;

import cn.maxiaot.factory.simplefactory.calculator.PerimeterCalculator;

public class PerimeterCalculatorExample {
    public static void main(String[] args) {
        PerimeterCalculator square = PerimeterCalculatorFactory.perimeterCalculator("Square");
        double v = square.perimeterCalculator(10);
        System.out.println(v);
    }
}
