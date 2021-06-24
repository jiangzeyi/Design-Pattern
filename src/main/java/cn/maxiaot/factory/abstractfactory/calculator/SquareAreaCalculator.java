package cn.maxiaot.factory.abstractfactory.calculator;

import java.math.BigDecimal;

/**
 * 正方形面积计算
 */
public class SquareAreaCalculator implements AreaCalculator {

    /**
     *正方形面积计算
     * @param n 边长
     * @return 正方形的面积
     */
    @Override
    public double areaCalculate(double n) {
        BigDecimal bigDecimal = new BigDecimal(n * n);
        return bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
