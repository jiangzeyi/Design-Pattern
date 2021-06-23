package cn.maxiaot.factory.abstractfactory.calculator;

/**
 * 圆的周长计算
 */
public class CirclePerimeterCalculate implements PerimeterCalculate {

    private static final double PI = 3.14;

    /**
     *圆的周长计算
     * @param n 半径
     * @return 圆的周长
     */
    @Override
    public double perimeterCalculate(int n) {
        return 2 * PI * n;
    }
}
