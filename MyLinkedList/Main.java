package MyLinkedList;
import MyLinkedList.MyList;
import MyLinkedList.LinkedListImpl;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyList<String> l1 = new LinkedListImpl<>();
        l1.add("10");
        l1.add("10");
        l1.add("10");
        l1.add("15");
        l1.add("20");
        l1.add("25");
        l1.add("30");
        l1.add("35");
        l1.remove(0);
        System.out.println("size: " + l1.size());
        for (int i = 0; i < l1.size(); i++) {
            System.out.println(l1.get(i));
        }
    }
}
