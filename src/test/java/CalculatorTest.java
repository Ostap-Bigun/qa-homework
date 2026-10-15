import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    void calculatorTestSumPositive() {
        assertEquals(3, Calculator.sum(1, 2));
    }

    @Test
    void calculatorTestSumZero() {
        assertEquals(0, Calculator.sum(0, 0));
    }

    @Test
    void calculatorTestSumNegative() {
        assertEquals(-3, Calculator.sum(-1, -2));
    }

    @Test
    void calculatorTestSubstractPositive() {
        assertEquals(2, Calculator.substract(3, 1));
    }

    @Test
    void calculatorTestSubstractZero() {
        assertEquals(0, Calculator.substract(0, 0));
    }

    @Test
    void calculatorTestSubstractNegative() {
        assertEquals(1, Calculator.substract(-1, -2));
    }


    @Test
    void calculatorTestMultiplyPositive() {
        assertEquals(3, Calculator.multiply(3, 1));
    }

    @Test
    void calculatorTestMultiplyZero() {
        assertEquals(0, Calculator.multiply(6, 0));
    }

    @Test
    void calculatorTestMultiplyNegative() {
        assertEquals(2, Calculator.multiply(-1, -2));
    }


    @Test
    void calculatorTestDividePositive() {
        assertEquals(2.0, Calculator.divide(6, 3));
    }

    @Test
    void calculatorTestDividePositiveFraction() {
        assertEquals(2.5, Calculator.divide(5, 2));
    }

    @Test
    void calculatorTestDivideZero() {
        assertEquals(0.0, Calculator.divide(0, 5));
    }

    @Test
    void calculatorTestDivideByZero() {
        assertThrows(ArithmeticException.class, ()-> Calculator.divide(5, 0));
    }

    @Test
    void calculatorTestDivideNegative() {
        assertEquals(-3.0, Calculator.divide(-6, 2));
    }

}
