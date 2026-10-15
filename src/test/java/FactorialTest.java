import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialTest {
    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][]{
                {5, 120},
                {1, 1},
                {0, 1}
        };
    }

    @Test(dataProvider = "factorialData")
    public void factorialTest(int number, int expected) {
        assertEquals(Factorial.factorial(number), expected);
    }
}

