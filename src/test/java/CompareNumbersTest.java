import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareNumbersTest {
    @Test
    void compareNumbersTestHigher() {
        assertEquals("a>b", CompareNumbers.compare(5, 2));
    }

    @Test
    void compareNumbersTestLower() {
        assertEquals("a<b", CompareNumbers.compare(2, 5));
    }

    @Test
    void compareNumbersTestEqual() {
        assertEquals("a=b", CompareNumbers.compare(5, 5));
    }
}
