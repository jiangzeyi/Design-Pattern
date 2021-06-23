package cn.maxiaot.factory.simple;

import cn.maxiaot.factory.simple.calculator.Calculate;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SimpleFactoryTest {
    @Test
    void calculateTest() {
        Scanner scanner = new Scanner(System.in);
        int n = 1;
        int m = 2;
        String operator = "+";
        Calculate instance = CalculateFactory.createCalculateInstance(operator);
        assert instance != null;
        int result = instance.calculate(n, m);
        System.out.println(n + "" + operator + "" + m + "=" +result);

    }
}