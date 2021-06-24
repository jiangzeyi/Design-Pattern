package cn.maxiaot.factory.abstractfactory.calculator;

import java.math.BigDecimal;

public class CirclePerimeterCalculator implements PerimeterCalculator {

    // 圆周率
    private static final double PI = 3.14;
    /**
     * 计算圆周长
     * @param n 圆半径
     * @return 圆周长
     */
    @Override
    public double perimeterCalculator(double n) {
        BigDecimal bigDecimal = new BigDecimal(2 * PI * n);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
