package homeTask_1.exersice_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//все тесты пройдут при запуске всего класса так как изменится рандомные числа в массиве
// ( связано с тем что seed находиться в main методе)
class ExerciseOneTest {
    int[][] testArray = ExerciseOne.createTwoDimensionalArray(6,5);

    @Test
    void findMinValue() {
        int expected=726;
        int actual=ExerciseOne.findMinValue(testArray);
        System.out.println("-------------------");
        ExerciseOne.showArrayToConsole(testArray);
        assertEquals(expected,actual);

    }

    @Test
    void findMaxValue() {
        int expected=10880;
        int actual=ExerciseOne.findMaxValue(testArray);
        System.out.println("-------------------");
        ExerciseOne.showArrayToConsole(testArray);
        assertEquals(expected,actual);

    }

    @Test
    void findAverageValue() {
        double expected=5265.633333333333;
        double actual=ExerciseOne.findAverageValue(testArray);
        System.out.println("-------------------");
        ExerciseOne.showArrayToConsole(testArray);
        assertEquals(expected,actual);

    }
}