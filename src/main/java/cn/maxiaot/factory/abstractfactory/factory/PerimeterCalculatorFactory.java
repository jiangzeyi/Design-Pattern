package cn.maxiaot.factory.abstractfactory.factory;

import cn.maxiaot.factory.abstractfactory.calculator.CirclePerimeterCalculator;
import cn.maxiaot.factory.abstractfactory.calculator.PerimeterCalculator;
import cn.maxiaot.factory.abstractfactory.calculator.SquarePerimeterCalculator;

/**
 * 周长计算工厂
 */
public class PerimeterCalculatorFactory {

    /**
     * 生成正方形周长计算实例
     * @return 正方形周长计算实例
     */
    public PerimeterCalculator createSquareCalculateInstance() {
        return new SquarePerimeterCalculator();
    }

    /**
     * 生成圆周长计算实例
     * @return 圆周长计算实例
     */
    public PerimeterCalculator createCircleCalculateInstance() {
        return new CirclePerimeterCalculator();
    }
}
