package cn.maxiaot.factory.abstractfactory;

import cn.maxiaot.factory.abstractfactory.calculator.AreaCalculate;
import cn.maxiaot.factory.abstractfactory.calculator.CalculateFactory;
import cn.maxiaot.factory.abstractfactory.calculator.PerimeterCalculate;
import org.junit.jupiter.api.Test;

class AbstractFactoryTest {

    @Test
    void abstractFactoryTest() {
        PerimeterCalculateFactory perimeterCalculateFactory = CalculateFactory.perimeterCalculateFactory();
        PerimeterCalculate circlePerimeter = perimeterCalculateFactory.createCircleCalculateInstance();
        circlePerimeter.perimeterCalculate(4);
        PerimeterCalculate squarePerimeter = perimeterCalculateFactory.createSquareCalculateInstance();
        circlePerimeter.perimeterCalculate(2);
        AreaCalculateFacotry areaCalculateFacotry = CalculateFactory.areaCalculateFacotry();
        AreaCalculate circleArea = areaCalculateFacotry.createCircleCalculateInstance();
        circleArea.areaCalculate(4);
        AreaCalculate squareArea = areaCalculateFacotry.createSquareCalculateInstance();
        squareArea.areaCalculate(4);
    }
}