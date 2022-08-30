package homeTask_1.exersice_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseTwoTest {

    @Test
    void sortArray() {
        int[] array = {5, 6, 3, 2, 5, 1, 4, 9};
        int[]expectedArray={1, 2, 3, 4, 5, 5, 6, 9};
        int[] actualArray=ExerciseTwo.sortArray(array);
        assertArrayEquals(expectedArray,actualArray);
    }
}