public class Homework2Part2 {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        selectCompareNumbers(99, 66);
        findBelowZero(-5);
        checkIfBelowZero(9);
        printLines("banana", 3);
        boolean result = isLeapYear(2024);
        invertArray();
        populateArray();
        multiplyBelowSix();
        fillSquareArray();
        createArray(2, 4);
    }

    static void printThreeWords() {
        System.out.println("orange");
        System.out.println("banana");
        System.out.println("apple");
    }

    static void checkSumSign() {
        int a = 2;
        int b = -22;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    static void printColor() {
        int value = 100;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    static void compareNumbers() {
        int a;
        a = 99;
        int b;
        b = 66;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    static void selectCompareNumbers(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    static void findBelowZero(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    static void checkIfBelowZero(int a) {
        if (a < 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    static void printLines(String line, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(line);
        }
    }

    static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    static void invertArray() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        System.out.println(java.util.Arrays.toString(array));
    }

    static void populateArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(java.util.Arrays.toString(array));
    }

    static void multiplyBelowSix() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
        System.out.println(java.util.Arrays.toString(array));
    }

    static void fillSquareArray() {
        int[][] array = new int[10][10];
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[i][array.length - 1 - i] = 1;
        }
        System.out.println(java.util.Arrays.deepToString(array));

    }

    static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        System.out.println(java.util.Arrays.toString(array));
        return array;
    }
}