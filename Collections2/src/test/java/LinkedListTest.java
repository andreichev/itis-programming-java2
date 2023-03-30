import itis.homework.impl.linkedlist.LinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTest {
    
    @Test
    public void testAdd() {
        LinkedListImpl<Integer> testLinkedList = new LinkedListImpl<Integer>();
        
        testLinkedList.add(1);
        testLinkedList.add(2);
        testLinkedList.add(3);
        testLinkedList.add(4);
        testLinkedList.add(5);
        
        Assertions.assertEquals((Integer) 5, testLinkedList.get(4));
    }
    
    @Test
    public void testInsert() {
        LinkedListImpl<Integer> testLinkedList = new LinkedListImpl<Integer>();
        
        testLinkedList.add(1);
        testLinkedList.add(2);
        testLinkedList.add(4);
        testLinkedList.add(5);
        
        testLinkedList.insert(2, 3);
        
        Assertions.assertEquals((Integer) 3, testLinkedList.get(2));
    }
    
    @Test
    public void testRemove() {
        LinkedListImpl<Integer> testLinkedList = new LinkedListImpl<Integer>();
        
        testLinkedList.add(1);
        testLinkedList.add(2);
        testLinkedList.add(3);
        testLinkedList.add(4);
        testLinkedList.add(5);
        
        testLinkedList.remove(0);
        
        Assertions.assertEquals((Integer) 2, testLinkedList.get(0));
    }
    
    @Test
    public void testGetSize() {
        LinkedListImpl<Integer> testLinkedList = new LinkedListImpl<Integer>();
        
        testLinkedList.add(1);
        testLinkedList.add(2);
        
        Assertions.assertEquals(2, testLinkedList.size());
        
        testLinkedList.add(3);
        testLinkedList.add(4);
        testLinkedList.add(5);
        
        Assertions.assertEquals(5, testLinkedList.size());
    }
}
