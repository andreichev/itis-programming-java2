
import itis.homework.base.MyList;
import itis.homework.impl.MyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HomeWorkCheck {
    @BeforeAll
    static void setup() {
        System.out.println("Begin of testing");
    }

    @Test
    void check() {
        MyList<String> list = new MyLinkedList<String>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.add("Seven");
        list.add("Eight");
        list.add("Nine");
        list.add("Ten");
        list.add("Eleven");
        list.add("Twelve");
        list.add("Thirteen");
        list.add("Fourteen");
        list.add("Fifteen");

        Assertions.assertEquals(list.get(2), "Three");
        list.remove(2);
        Assertions.assertEquals(list.get(2), "Four");
    }
}
