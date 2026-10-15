import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {
    @Test
    void factorialTest5() {
        assertEquals(120, Factorial.factorial(5));
    }

    @Test
    void factorialTest0() {
        assertEquals(1, Factorial.factorial(0));
    }

    @Test
    void factorialTest1() {
        assertEquals(1, Factorial.factorial(1));
    }
}
