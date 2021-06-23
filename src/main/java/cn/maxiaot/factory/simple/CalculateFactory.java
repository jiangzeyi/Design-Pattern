package cn.maxiaot.factory.simple;

import cn.maxiaot.factory.simple.calculator.*;

import java.util.Arrays;

/**
 * 计算工厂
 */
public class CalculateFactory {

    private static final String[] OPERATOR = {"+", "-", "*", "/"};

    /**
     * 生成计算实例
     * @param operator 运算符
     * @return 计算实例
     */
    public static Calculate createCalculateInstance(String operator) {

        if (! Arrays.asList(OPERATOR).contains(operator)) {
            throw new RuntimeException("请输入合法的运算符");
        }
        if("+".equals(operator)) {
            return new AddCalculate();
        }
        if("-".equals(operator)) {
            return new MinusCalculate();
        }
        if("*".equals(operator)) {
            return new MulCalculate();
        }
        if("/".equals(operator)) {
            return new DivCalculate();
        }
        return null;
    }
}
