package cn.maxiaot.factory.abstractfactory.calculator;

import cn.maxiaot.factory.abstractfactory.AreaCalculateFacotry;
import cn.maxiaot.factory.abstractfactory.PerimeterCalculateFactory;

/**
 * 计算工厂
 */
public class CalculateFactory {

    /**
     * 生成周长计算工厂实例
     * @return 周长计算工厂实例
     */
    public static PerimeterCalculateFactory perimeterCalculateFactory() {
        return new PerimeterCalculateFactory();
    }

    /**
     * 生成面积计算工厂实例
     * @return 面积计算工厂实例
     */
    public static AreaCalculateFacotry areaCalculateFacotry() {
        return new AreaCalculateFacotry();
    }
}
