public class CheckArray {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        try {
            int result = sumArray(array);
            System.out.println("Сумма массива = " + result);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(array[4][4]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Выход за границы массива!");
        }
    }


    static int sumArray(String[][] array) {
        int sum = 0;

        if (array.length != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4х4!");
        }

        for (int i = 0; i < 4; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Размер массива должен быть 4х4!");
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    int number = Integer.parseInt(array[i][j]);
                    sum = sum + number;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверный тип данных в ячейке [" + i + "][" + j + "]");

                }

            }
        }
        return sum;

    }


}
