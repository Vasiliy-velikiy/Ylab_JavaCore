package homeTask_2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ComplexExamplesTest {


    /**
     * Тест для 1 задания
     */
    @Test
    void removeDublicateAndSortedHasMap() {
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("Amelia", 4);
        expected.put("Emily", 1);
        expected.put("Harry", 3);
        expected.put("Jack", 1);

        ComplexExamples.Person[] RAW_DATA = new ComplexExamples.Person[]{
                new ComplexExamples.Person(0, "Harry"),
                new ComplexExamples.Person(0, "Harry"), // дубликат
                new ComplexExamples.Person(1, "Harry"), // тёзка
                new ComplexExamples.Person(2, "Harry"),
                new ComplexExamples.Person(3, "Emily"),
                new ComplexExamples.Person(4, "Jack"),
                new ComplexExamples.Person(4, "Jack"),
                new ComplexExamples.Person(5, "Amelia"),
                new ComplexExamples.Person(5, "Amelia"),
                new ComplexExamples.Person(6, "Amelia"),
                new ComplexExamples.Person(7, "Amelia"),
                new ComplexExamples.Person(8, "Amelia"),
        };
        Map<String, Integer> actual = ComplexExamples.removeDublicateAndSortedHasMap(RAW_DATA);
        assertEquals(expected, actual);
    }

    /**
     * Тест для 2 задания
     */
    @Test
    void pairSumTen() {
        int sum = 10;
        int[] array1 = new int[]{3, 4, 2, 7};
        int[] array2 = new int[]{7, 4, 3, 3};
        int[] array3 = new int[]{1, 9, 7, 3};
        int[] array4 = new int[]{7, 4, 1, 2, 15, 8, 6, 13};

        int[] expected1 = new int[]{3, 7};
        int[] expected2 = new int[]{7, 3};
        int[] expected3 = new int[]{1, 9};
        int[] expected4 = new int[]{4, 6};

        int[] actual1 = ComplexExamples.pairSumTen(array1, sum);
        int[] actual2 = ComplexExamples.pairSumTen(array2, sum);
        int[] actual3 = ComplexExamples.pairSumTen(array3, sum);
        int[] actual4 = ComplexExamples.pairSumTen(array4, sum);
        boolean answer1 = Arrays.equals(expected1, actual1);
        boolean answer2 = Arrays.equals(expected2, actual2);
        boolean answer3 = Arrays.equals(expected3, actual3);
        boolean answer4 = Arrays.equals(expected4, actual4);

        assertEquals(true, answer1);
        assertEquals(true, answer2);
        assertEquals(true, answer3);
        assertEquals(true, answer4);


    }

    /**
     * Тест для 3 задания
     */
    @Test
    void fuzzySearch() {
        boolean actual1 = ComplexExamples.fuzzySearch("car", "ca6$$#_rtwheel");
        boolean actual2 = ComplexExamples.fuzzySearch("cwhl", "cartwheel");
        boolean actual3 = ComplexExamples.fuzzySearch("cwhee", "cartwheel");
        boolean actual4 = ComplexExamples.fuzzySearch("cartwheel", "cartwheel");
        boolean actual5 = ComplexExamples.fuzzySearch("cwheeel", "cartwheel");
        boolean actual6 = ComplexExamples.fuzzySearch("lw", "cartwheel");

        assertEquals(true, actual1);
        assertEquals(true, actual2);
        assertEquals(true, actual3);
        assertEquals(true, actual4);
        assertEquals(false, actual5);
        assertEquals(false, actual6);
    }

}