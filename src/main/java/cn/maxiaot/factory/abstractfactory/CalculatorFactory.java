package cn.maxiaot.factory.abstractfactory;

import cn.maxiaot.factory.abstractfactory.factory.AreaCalculatorFacotry;
import cn.maxiaot.factory.abstractfactory.factory.PerimeterCalculatorFactory;

public class CalculatorFactory {

    public static PerimeterCalculatorFactory perimeterCalculatorFactory() {
        return new PerimeterCalculatorFactory();
    }

    public static AreaCalculatorFacotry areaCalculatorFacotry() {
        return new AreaCalculatorFacotry();
    }
}
