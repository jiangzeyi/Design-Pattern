package cn.maxiaot.factory.simple.calculator;

/**
 * 乘法运算
 */
public class MulCalculate implements  Calculate {

    @Override
    public Integer calculate(Integer n, Integer m) {
        return n * m;
    }
}
