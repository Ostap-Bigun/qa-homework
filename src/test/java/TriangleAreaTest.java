import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleAreaTest {
    @Test
    void triangleAreaTestPositive() {
        assertEquals(7.5, TriangleArea.triangleArea(5, 3));
    }
    @Test
    void triangleAreaTestZeroSide() {
        assertEquals(0.0, TriangleArea.triangleArea(0, 3));
    }
    @Test
    void triangleAreaTestZeroHight() {
        assertEquals(0.0, TriangleArea.triangleArea(5, 0));
    }
}
