package homeTask_2;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Класс описыващее задачу от автора
 * все тесты на методы находятся в test/java/homeTask_2
 */
public class ComplexExamples {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    private static int[] ARRAYFORTASKTWO1 = new int[]{3, 4, 2, 7};
    private static int[] ARRAYFORTASKTWO2 = new int[]{7, 4, 3, 3};
    private static int[] ARRAYFORTASKTWO3 = new int[]{1, 9, 7, 3};
    private static int[] ARRAYFORTASKTWO4 = new int[]{7, 4, 1, 2, 15, 8, 6, 3, 13};
        /*  Raw data:

        0 - Harry
        0 - Harry
        1 - Harry
        2 - Harry
        3 - Emily
        4 - Jack
        4 - Jack
        5 - Amelia
        5 - Amelia
        6 - Amelia
        7 - Amelia
        8 - Amelia

        **************************************************

        Duplicate filtered, grouped by name, sorted by name and id:

        Amelia:
        1 - Amelia (5)
        2 - Amelia (6)
        3 - Amelia (7)
        4 - Amelia (8)
        Emily:
        1 - Emily (3)
        Harry:
        1 - Harry (0)
        2 - Harry (1)
        3 - Harry (2)
        Jack:
        1 - Jack (4)
     */

    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        /*
        Task1
            Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени

            Что должно получиться
                Key: Amelia
                Value:4
                Key: Emily
                Value:1
                Key: Harry
                Value:3
                Key: Jack
                Value:1
         */


        /*
        Task2

            [3, 4, 2, 7], 10 -> [3, 7] - вывести пару именно в скобках, которые дают сумму - 10
         */



        /*
        Task3
            Реализовать функцию нечеткого поиска

                    fuzzySearch("car", "ca6$$#_rtwheel"); // true
                    fuzzySearch("cwhl", "cartwheel"); // true
                    fuzzySearch("cwhee", "cartwheel"); // true
                    fuzzySearch("cartwheel", "cartwheel"); // true
                    fuzzySearch("cwheeel", "cartwheel"); // false
                    fuzzySearch("lw", "cartwheel"); // false
         */

        //вывод 1го задания на экран
        System.out.println("task1");
        printValuesInHasMap(removeDublicateAndSortedHasMap(RAW_DATA));
        System.out.println("**************************************************");

        //вывод 2го задания на экран
        System.out.println("task2");
        printValuesInArray(pairSumTen(ARRAYFORTASKTWO1, 10));
        printValuesInArray(pairSumTen(ARRAYFORTASKTWO2, 10));
        printValuesInArray(pairSumTen(ARRAYFORTASKTWO3, 10));
        printValuesInArray(pairSumTen(ARRAYFORTASKTWO4, 10));
        System.out.println("**************************************************");

        //вывод 3го задания
        System.out.println("task3");
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); // true
        System.out.println(fuzzySearch("cwhl", "cartwheel")); // true
        System.out.println(fuzzySearch("cwhee", "cartwheel")); // true
        System.out.println(fuzzySearch("cartwheel", "cartwheel")); // true
        System.out.println(fuzzySearch("cwheeel", "cartwheel")); // false
        System.out.println(fuzzySearch("lw", "cartwheel")); // false

    }

    /**
     * Для 1 задания
     * Метод удаляет дублирующиеся значения , добавляет в хешмапу ИМЯ:КОЛИЧЕСТВО ВХОЖДЕНИЙ ПО ИМЕНИ и группирует по имени
     *
     * @param RAW_DATA массив из Person
     * @return отсориторванная hashmap с уникальными значениями и числом вхождений по имени
     */
    public static Map<String, Integer> removeDublicateAndSortedHasMap(Person[] RAW_DATA) {
        System.out.println("method removeDublicateAndSortedHasMap");
        Map<String, Integer> result = new TreeMap<>();
                                               // проверка на null
        Arrays.stream(RAW_DATA).filter(Objects::nonNull).filter(person -> person.getName() != null).distinct().forEach(person -> result.merge(person.getName(), 1, Integer::sum));
        return result;
    }


    /**
     * Вывод значений hasmap на экран
     *
     * @param map
     */
    public static void printValuesInHasMap(Map<String, Integer> map) {
        map.forEach((key, value) -> System.out.println("Key: " + key + "\nValue: " + value));
    }

    /**
     * Для 2 задания
     *
     * @param array-        массив с целыми числами
     * @param sum-требуемая сумма для 2х чисел
     * @return массив дающий сумму 10 в строгой последовательности как в исходном
     * если в массиве встретилось 2 пары дающие 10 в сумме,вывод будет на первую найденную
     */
    public static int[] pairSumTen(int[] array, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();//ключ,значение-само число из массива
        int[] arrayNotNull = Arrays.stream(array).filter(Objects::nonNull).toArray(); //проверка на null
        for (int i = 0; i < arrayNotNull.length; i++) {
            if (map.get(sum - arrayNotNull[i]) == null) {
                map.put(arrayNotNull[i], arrayNotNull[i]);
            } else {
                return new int[]{map.get(sum - arrayNotNull[i]), arrayNotNull[i]};
            }
        }
        return new int[2];
    }

    /**
     * вывод на экран пары значений дающих в сумме 10 в виде [3, 7]
     */
    public static void printValuesInArray(int[] array) {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < array.length; i++) {
            str.append(array[i]);
            if (i != array.length - 1) {
                str.append(",");
            }
        }
        str.append("]");
        System.out.println(str.toString());
    }

    /**
     * Для 3 задания
     *
     * @param pattern -искомые буквы
     * @param string  -место поиска
     * @return true если в string содержаться буквы в строгой последовательности как в pattern
     */
    public static boolean fuzzySearch(String pattern, String string) {
        if (pattern != null && string != null) { //проверка на null
            int indexChar = -2;//;
            for (char elem : pattern.toCharArray()) {
                if (indexChar > string.indexOf(elem) || string.indexOf(elem) == -1) return false;
                else {
                    indexChar = string.indexOf(elem);
                    string = string.replaceFirst(String.valueOf(string.charAt(indexChar)), ""); //по очереди удаляем символи в искомой строке
                }
            }
            return true;
        } else return false;
    }

}

