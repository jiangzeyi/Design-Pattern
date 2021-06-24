package cn.maxiaot.factory.abstractfactory.calculator;

import cn.maxiaot.factory.abstractfactory.factory.AreaCalculatorFacotry;
import cn.maxiaot.factory.abstractfactory.factory.PerimeterCalculatorFactory;

/**
 * 计算工厂
 */
public class CalculateFactory {

    /**
     * 生成周长计算工厂实例
     * @return 周长计算工厂实例
     */
    public static PerimeterCalculatorFactory perimeterCalculateFactory() {
        return new PerimeterCalculatorFactory();
    }

    /**
     * 生成面积计算工厂实例
     * @return 面积计算工厂实例
     */
    public static AreaCalculatorFacotry areaCalculateFacotry() {
        return new AreaCalculatorFacotry();
    }
}
