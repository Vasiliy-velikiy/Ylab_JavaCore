package homeTask_1.exersice_2;

//Задание2. Отсортируйте массив [5,6,3,2,5,1,4,9]
//ps-тесты сделаны на Junit
public class ExerciseTwo {
    public static void main(String[] args) {

        int[] array = {5, 6, 3, 2, 5, 1, 4, 9};
        int[] sortedArray = sortArray(array);
        showArray(sortedArray);
        System.out.println();
        showArray(array);
    }

    /**
     * Метод сортировки от меньшего к большему с учетом дублей
     */
    public static int[] sortArray(int[] array) {
        int[] sortedArray = array.clone();
        for (int i = sortedArray.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (sortedArray[j] >= sortedArray[j + 1]) {
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }
        return sortedArray;
    }

    /**
     * Метод вывода на экран массива
     */
    public static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
