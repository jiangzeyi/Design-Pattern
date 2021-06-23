package cn.maxiaot.factory.abstractfactory.calculator;

/**
 * 正方形面积计算
 */
public class SquareAreaCalculate implements AreaCalculate {

    /**
     *正方形面积计算
     * @param n 边长
     * @return 正方形的面积
     */
    @Override
    public double areaCalculate(int n) {
        return n * n;
    }
}
