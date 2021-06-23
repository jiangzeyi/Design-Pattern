package cn.maxiaot.factory.abstractfactory;

import cn.maxiaot.factory.abstractfactory.calculator.Calculate;

/**
 * 计算抽象工厂
 */
public abstract class AbstractCalculateFactory {
    public abstract Calculate createCalculateInstance();
}
