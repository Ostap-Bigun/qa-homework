import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;


public class CalculatorTest {
    @BeforeClass
    public void beforeClass() {
        System.out.println("Starting Calculator tests");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Starting test");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Test finished");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Calculator tests finished");
    }

    @DataProvider(name = "sumData")
    public Object[][] sumData() {
        return new Object[][]{
                {3, 1, 2},
                {0, 0, 0},
                {-3, -1, -2}
        };
    }

    @Test(dataProvider = "sumData")
    public void calculatorTestSum(int expected, int a, int b) {
        assertEquals(Calculator.sum(a, b), expected);
    }

    @DataProvider(name = "subtractData")
    public Object[][] subtractData() {
        return new Object[][]{
                {2, 3, 1},
                {0, 0, 0},
                {1, -1, -2}
        };
    }

    @Test(dataProvider = "subtractData")
    public void calculatorTestSubtract(int expected, int a, int b) {
        assertEquals(Calculator.substract(a, b), expected);
    }

    @DataProvider(name = "multiplyData")
    public Object[][] multiplyData() {
        return new Object[][]{
                {3, 3, 1},
                {0, 6, 0},
                {2, -1, -2}
        };
    }

    @Test(dataProvider = "multiplyData")
    public void calculatorTestMultiply(int expected, int a, int b) {
        assertEquals(Calculator.multiply(a, b), expected);
    }

    @DataProvider(name = "divideData")
    public Object[][] divideData() {
        return new Object[][]{
                {2.0, 6, 3},
                {2.5, 5, 2},
                {0.0, 0, 5},
                {-3.0, -6, 2}
        };
    }

    @Test(dataProvider = "divideData")
    public void calculatorTestDivide(double expected, int a, int b) {
        assertEquals(Calculator.divide(a, b), expected);
    }

    @Test
    void calculatorTestDivideByZero() {
        assertThrows(ArithmeticException.class,
                () -> Calculator.divide(5, 0));
    }

}
