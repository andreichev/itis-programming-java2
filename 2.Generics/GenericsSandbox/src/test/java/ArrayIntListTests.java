import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.itis.collections.list.CoolArrayList;
import ru.itis.collections.list.CoolList;

public class ArrayIntListTests {
    CoolList<Integer> list;

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Begin of testing");
    }

    @BeforeEach
    void beforeEachTest() {
        list = new CoolArrayList<>();
    }

    @Test
    void checkAddSizeClear() {
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals(2, list.get(1));
        list.clear();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void checkRemove() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        Assertions.assertEquals(3, list.get(1));
    }

    @Test
    void checkInsertAt() {
        list.add(1);
        // Вставить элемент 2 в начало списка
        list.add(2, 0);
        // 2 1
        list.add(3);
        // 2 1 3
        list.add(4, 1);
        // 2 4 1 3
        Assertions.assertEquals(2, list.get(0));
        Assertions.assertEquals(4, list.get(1));
        Assertions.assertEquals(4, list.size());
    }
}
