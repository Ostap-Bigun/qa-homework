public class Calculator {
    static int sum(int a, int b) {
        int sum = a + b;
        return sum;
    }

    static int substract(int a, int b) {
        int substract = a - b;
        return substract;
    }

    static double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        double divide = (double) a / b;
        return divide;
    }

    static int multiply(int a, int b) {
        int multiply = a * b;
        return multiply;
    }

}
