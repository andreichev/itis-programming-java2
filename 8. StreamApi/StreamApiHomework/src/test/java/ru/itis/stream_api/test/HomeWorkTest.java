package ru.itis.stream_api.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.itis.stream_api.model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HomeWorkTest {
    static List<Student> getStudents() {
        return Arrays.asList(
                new Student("Ivan", "Ivanov", 50),
                new Student("Vasya", "Sidorov", 60),
                new Student("Anton", "Antonov", 70),
                new Student("Andrey", "Kuznecov", 80),
                new Student("Oleg", "Kulikov", 10),
                new Student("Ashot", "Ahmetov", 20)
        );
    }

    @Test
    void checkTask1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        // TODO: Применить умножение каждого элемента на 2

        Assertions.assertEquals(2, list.get(0));
        Assertions.assertEquals(4, list.get(1));
        Assertions.assertEquals(6, list.get(2));
        Assertions.assertEquals(8, list.get(3));
    }

    @Test
    void checkTask2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        // TODO: Отфильтровать элементы, оставив только четные

        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals(2, list.get(0));
        Assertions.assertEquals(4, list.get(1));
    }

    @Test
    void checkTask3() {
        List<String> list = Arrays.asList("Ivanov", "Sidorov", "Antonov", "Kuznecov", "Kulikov", "Ahmetov");

        // TODO: Отсортировать по алфавиту

        Assertions.assertEquals("Antonov", list.get(1));
        Assertions.assertEquals("Ivanov", list.get(2));
        Assertions.assertEquals("Kuznecov", list.get(4));
    }

    @Test
    void checkTask4() {
        List<Student> list = getStudents();

        // TODO: Отсортировать по score и по алфавиту, выбрать только тех, у кого score больше или равно 56

        Assertions.assertEquals("Kuznecov", list.get(0).getLastName());
        Assertions.assertEquals("Antonov", list.get(1).getLastName());
        Assertions.assertEquals(60, list.get(2).getScore());
    }

    @Test
    void checkTask5() {
        List<Student> list = getStudents();

        int count = 0;
        // TODO: посчитать количество троечников (у кого score больше или равно 56 и меньше или равно 70)

        Assertions.assertEquals(count, 2);
    }
}
