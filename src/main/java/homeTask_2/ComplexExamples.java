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
    private static int[] ARRAYFORTASKTWO4 = new int[]{7, 4, 1, 2, 15, 8, 6, 13};
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

        List<Person> personList = new ArrayList<Person>(Arrays.asList(RAW_DATA));

        //map для осториторванных по имени
        Map<String, Integer> result = new LinkedHashMap<>();

        List<Person> finalPersonList = personList;
        personList.stream().filter(Objects::nonNull).distinct().sorted(Comparator.comparing(e -> e.getName())).map(elem -> {
            long count = finalPersonList.stream().distinct().filter(elem2 -> elem2.getName().equals(elem.getName())).count(); //число вхождений по имени
            result.put(elem.getName(), (int) count);
            return elem;
        }).collect(Collectors.toList());

        return result;
    }


    /**
     * Вывод значений hasmap на экран
     *
     * @param map
     */
    public static void printValuesInHasMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println("Key: " + pair.getKey() + "\nValue: " + pair.getValue());
        }
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
        int[] result = new int[2];
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    result[0] = array[i];
                    result[1] = array[j];
                }
                if (result[0] != 0 && result[1] != 0) {
                    return result;
                }
            }
        }
        return result;
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

        //преобразую string в списко для удобства манипулирования
        List<Character> patternCharList = pattern.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        List<Character> stringCharList = string.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        //эти списки необходимы для итерации и удаления
        List<Character> patternCheckList = new ArrayList<>(patternCharList);
        List<Character> stringCheckList = new ArrayList<>(stringCharList);

        int indexChar = 0;

        for (int i = 0; i < patternCharList.size(); i++) {
            for (int j = 0; j < stringCharList.size(); j++) {
                if (stringCharList.get(j) == patternCharList.get(i)) {
                    if (indexChar <= j) {//если индекс настоящего удаления меньше предидущего-то буквы уже не сохраняют порядок как в патерне-return false
                        indexChar = j;
                        patternCheckList.remove(patternCharList.get(i));
                        if (stringCheckList.remove(stringCharList.get(j))) {//если удаляемого элемента нет в списке- количество букв как в патерне не достает return false
                            break;
                        } else return false;
                    } else return false;
                }
            }
        }
        if (patternCheckList.isEmpty())
            return true; //если к концу итерации прошли по всем елементам patternCharList то нашли все буквы в string
        else return false;
    }

}
