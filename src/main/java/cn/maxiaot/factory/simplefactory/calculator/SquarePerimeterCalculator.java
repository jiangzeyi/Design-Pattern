package cn.maxiaot.factory.simplefactory.calculator;

import java.math.BigDecimal;

public class SquarePerimeterCalculator implements PerimeterCalculator {

    /**
     * 计算正方形周长
     * @param n 边长
     * @return 正方形周长
     */
    @Override
    public double perimeterCalculator(double n) {
        BigDecimal bigDecimal = new BigDecimal(n * 4);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
