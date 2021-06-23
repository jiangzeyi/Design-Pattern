package cn.maxiaot.factory.simplefactory.calculator;

/**
 * 除法运算
 */
public class DivCalculate implements Calculate {

    @Override
    public Integer calculate(Integer n, Integer m) {
        return n / m;
    }
}
