package cn.maxiaot.factory.simplefactory;

import cn.maxiaot.factory.simplefactory.calculator.CirclePerimeterCalculator;
import cn.maxiaot.factory.simplefactory.calculator.PerimeterCalculator;
import cn.maxiaot.factory.simplefactory.calculator.SquarePerimeterCalculator;

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
