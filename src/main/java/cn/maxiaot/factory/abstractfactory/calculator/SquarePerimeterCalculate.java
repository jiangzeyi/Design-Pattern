package cn.maxiaot.factory.abstractfactory.calculator;

/**
 * 正方形周长计算
 */
public class SquarePerimeterCalculate implements PerimeterCalculate {

    /**
     *正方形周长计算
     * @param n 边长
     * @return 正方形的周长
     */
    @Override
    public double perimeterCalculate(int n) {
        return n * 4;
    }
}
