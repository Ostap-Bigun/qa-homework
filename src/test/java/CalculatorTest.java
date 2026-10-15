import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@DisplayName("Calculator tests")
public class CalculatorTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Starting Calculator tests");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Starting test");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Test finished");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Calculator tests finished");
    }

    @ParameterizedTest
    @DisplayName("Testing addition")
    @CsvSource({
            "3, 1, 2",
            "0, 0, 0",
            "-3, -1, -2"
    })
    void calculatorTestSum(int expected, int a, int b) {
        assertEquals(expected, Calculator.sum(a, b));
    }

    @ParameterizedTest
    @DisplayName("Testing subtraction")
    @CsvSource({
            "2, 3,1",
            "0, 0, 0",
            "1,-1,-2"
    })
    void calculatorTestSubstract(int expected, int a, int b) {

        assertEquals(expected, Calculator.substract(a, b));
    }

    @ParameterizedTest
    @DisplayName("Testing multiplication")
    @CsvSource({
            "3, 3,1",
            "0, 6, 0",
            "2,-1,-2"
    })
    void calculatorTestMultiply(int expected, int a, int b) {

        assertEquals(expected, Calculator.multiply(a, b));
    }

    @ParameterizedTest
    @DisplayName("Testing division")
    @CsvSource({
            "2.0, 6,3",
            "2.5, 5, 2",
            "0.0,0,5",
            "-3.0,-6,2"
    })
    void calculatorTestDivide(double expected, int a, int b) {

        assertEquals(expected, Calculator.divide(a, b));
    }


    @Test
    void calculatorTestDivideByZero() {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(5, 0));
    }


}


