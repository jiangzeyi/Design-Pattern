package cn.maxiaot.factory.simple.calculator;

/**
 * 减法运算
 */
public class MinusCalculate implements Calculate {

    @Override
    public Integer calculate(Integer n, Integer m) {
        return n - m;
    }
}
