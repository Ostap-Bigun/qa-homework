import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DisplayName("Testing Factorial")
public class FactorialTest {
    @ParameterizedTest
    @CsvSource({
            "5, 120",
            "1,1",
            "0,1"
    })
    void factorialTest(int number, int expected) {
        assertEquals(expected, Factorial.factorial(number));
    }
}