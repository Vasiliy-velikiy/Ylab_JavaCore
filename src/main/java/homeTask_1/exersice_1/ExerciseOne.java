package homeTask_1.exersice_1;


//Задание1. Заполните двумерный массив случайным числами и выведите максимальное, минимальное и среднее значение.
public class ExerciseOne {
    static int seed = 100; //начальная точка отсчета, необходимая для генерации случ чисел
    //при повторном запуске программы изменить значение

    public static void main(String[] args) {

        int[][] testArray = createTwoDimensionalArray(6, 5);

        showArrayToConsole(testArray);
        System.out.println();
        System.out.println("минимальное значение : "+findMinValue(testArray));
        System.out.println("максимальное значение : "+findMaxValue(testArray));
        System.out.println("среднее значение : "+findAverageValue(testArray));

    }

    /**
     * метод для создания двумерного массива и заполнения рандомными числами
     */
    public static int[][] createTwoDimensionalArray(int height, int width) {
        int[][] array = new int[height][width];
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                array[j][i] = createRandomInt();
            }
        }
        return array;
    }

    /**
     * создание рандомного числа
     */
    public static int createRandomInt() {
        int a = 41;
        int c = 11119;
        int m = 11113;

        seed = (a * seed + c) % m;
        return seed;
    }

    /**
     * вывод массива в консоль
     */
    public static void showArrayToConsole(int[][] array) {
        System.out.println("значение массива");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Нахождение минимального числа в массиве
     */
    public static int findMinValue(int[][] array) {
        int min = array[0][0];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (min >= array[i][j]) {
                    min = array[i][j];
                }
            }
        }
        return min;
    }

    /**
     * Нахождение максимального числа в массиве
     */
    public static int findMaxValue(int[][] array) {
        int max = array[0][0];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (max <= array[i][j]) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    /**
     * Нахождение среднего в массиве
     */
    public static double findAverageValue(int[][] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                sum += array[i][j];
            }
        }
        //System.out.println("sum= " + sum);
        double average =(double) sum / (array.length * array[0].length);
        return average;
    }
}
