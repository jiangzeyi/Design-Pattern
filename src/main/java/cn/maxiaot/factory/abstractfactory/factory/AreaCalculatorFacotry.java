package cn.maxiaot.factory.abstractfactory.factory;

import cn.maxiaot.factory.abstractfactory.calculator.AreaCalculator;
import cn.maxiaot.factory.abstractfactory.calculator.CircleAreaCalculator;
import cn.maxiaot.factory.abstractfactory.calculator.SquareAreaCalculator;

/**
 * 面积计算工厂
 */
public class AreaCalculatorFacotry {

    /**
     * 生成正方形面积计算实例
     * @return 正方形面积计算实例
     */
    public AreaCalculator createSquareCalculateInstance() {
        return new SquareAreaCalculator();
    }


    /**
     * 生成圆面积计算实例
     * @return 圆面积计算实例
     */
    public AreaCalculator createCircleCalculateInstance() {
        return new CircleAreaCalculator();
    }
}
