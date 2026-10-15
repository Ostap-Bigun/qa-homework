import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testing Number Comparison")
public class CompareNumbersTest {
    @ParameterizedTest
    @CsvSource({
            "a>b, 5,2",
            "a<b, 2,5",
            "a=b,5,5"
    })
    void compareNumbersTest(String expected, int a, int b) {
        assertEquals(expected, CompareNumbers.compare(a, b));
    }
}
