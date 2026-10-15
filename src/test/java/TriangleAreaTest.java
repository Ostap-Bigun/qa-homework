import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TriangleAreaTest {

    @DataProvider(name = "triangleAreaData")
    public Object[][] triangleAreaData() {
        return new Object[][]{
                {7.5, 5, 3},
                {0.0, 0, 3},
                {0.0, 5, 0}
        };
    }

    @Test(dataProvider = "triangleAreaData")
    public void triangleAreaTest(double expected, int a, int h) {
        assertEquals(TriangleArea.triangleArea(a, h), expected);
    }
}

