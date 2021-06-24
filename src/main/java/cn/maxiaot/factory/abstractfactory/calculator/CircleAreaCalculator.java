package cn.maxiaot.factory.abstractfactory.calculator;

import java.math.BigDecimal;

/**
 * 圆的面积计算
 */
public class CircleAreaCalculator implements AreaCalculator {

    private static final double PI = 3.14;

    /**
     *圆的面积计算
     * @param n 半径
     * @return 圆的面积
     */
    @Override
    public double areaCalculate(double n) {
        BigDecimal bigDecimal = new BigDecimal(PI * n * n);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
