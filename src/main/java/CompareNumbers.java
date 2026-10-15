public class CompareNumbers {
    static String compare(int a, int b) {
        String result;
        if (a > b) {
            result = "a>b";
        } else if (a < b) {
            result = "a<b";
        } else {
            result = "a=b";
        }
        return result;
    }
}
