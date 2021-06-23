package cn.maxiaot.factory.abstractfactory;

import cn.maxiaot.factory.abstractfactory.calculator.CirclePerimeterCalculate;
import cn.maxiaot.factory.abstractfactory.calculator.PerimeterCalculate;
import cn.maxiaot.factory.abstractfactory.calculator.SquarePerimeterCalculate;

/**
 * 周长计算工厂
 */
public class PerimeterCalculateFactory {

    /**
     * 生成正方形周长计算实例
     * @return 正方形周长计算实例
     */
    public PerimeterCalculate createSquareCalculateInstance() {
        return new SquarePerimeterCalculate();
    }

    /**
     * 生成圆周长计算实例
     * @return 圆周长计算实例
     */
    public PerimeterCalculate createCircleCalculateInstance() {
        return new CirclePerimeterCalculate();
    }
}
