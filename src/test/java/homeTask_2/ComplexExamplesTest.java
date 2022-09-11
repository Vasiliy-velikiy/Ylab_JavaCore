package homeTask_2;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ComplexExamplesTest {


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
}