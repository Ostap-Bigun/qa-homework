import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CompareNumbersTest {

    @DataProvider(name = "compareData")
    public Object[][] compareData() {
        return new Object[][]{
                {"a>b", 5, 2},
                {"a<b", 2, 5},
                {"a=b", 5, 5}
        };
    }

    @Test(dataProvider = "compareData")
    public void compareNumbersTest(String expected, int a, int b) {
        assertEquals(CompareNumbers.compare(a, b), expected);
    }
}