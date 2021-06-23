package cn.maxiaot.factory.abstractfactory;

import cn.maxiaot.factory.abstractfactory.calculator.AreaCalculate;
import cn.maxiaot.factory.abstractfactory.calculator.CircleAreaCalculate;
import cn.maxiaot.factory.abstractfactory.calculator.SquareAreaCalculate;

/**
 * 面积计算工厂
 */
public class AreaCalculateFacotry{

    /**
     * 生成正方形面积计算实例
     * @return 正方形面积计算实例
     */
    public AreaCalculate createSquareCalculateInstance() {
        return new SquareAreaCalculate();
    }


    /**
     * 生成圆面积计算实例
     * @return 圆面积计算实例
     */
    public AreaCalculate createCircleCalculateInstance() {
        return new CircleAreaCalculate();
    }
}
