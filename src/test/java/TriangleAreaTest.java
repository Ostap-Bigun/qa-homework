import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DisplayName("Testing Triangle Area")
public class TriangleAreaTest {
    @ParameterizedTest
    @CsvSource({
            "7.5,5,3",
            "0.0,0,3",
            "0.0,5,0"
    })
    void triangleAreaTestPositive(double expected, int a, int h) {

        assertEquals(expected, TriangleArea.triangleArea(a, h));
    }

}
