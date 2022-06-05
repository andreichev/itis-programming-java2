package MyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import MyLinkedList.LinkedListImpl;
import MyLinkedList.MyList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class Tests {
    static MyList<String> l1 = new LinkedListImpl<>();
    @BeforeAll
    public static void init() {
        l1.add("1");
        l1.add("2");
        l1.add("3");
        l1.add("4");
        l1.add("5");
        l1.add("6");
        l1.add("7");
        l1.add("8");
    }

    @Test
    public void TestAdd() {
        Assertions.assertEquals(8, l1.size());
    }

    @Test
    public void TestRemoveByIndex() {
        l1.remove(2);
        Assertions.assertEquals("4", l1.get(2));
    }

    @Test
    public void TestRemoveByObject() {
        l1.remove("8");
        Assertions.assertEquals("7", l1.get(6));
    }

    @Test
    public void TestRemoveHead() {
        l1.remove();
        Assertions.assertEquals("2", l1.get(0));
    }

    @Test
    public void TestGet() {
        Assertions.assertEquals("5", l1.get(4));
    }
}
