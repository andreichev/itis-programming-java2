package HomeWork.MyLinkedList;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyLinkedList<T>{
    static class MyLinkedListIterator<T> implements Iterator<T> {
        private Node current;

        public MyLinkedListIterator(Node first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public T next() {
            current = current.next;
            return (T) current.value;
        }
    }

    private static class Node {
        Node next;
        Object value;

        public Node(Object value) {
            this.value = value;
            this.next = null;
        }
    }

    Node first;
    Node last;
    int size = 0;

    public void add(T element) {
        if(first == null) {
            first = new Node(element);
            last = first;
        } else {
            last.next = new Node(element);
            last = last.next;
        }
        size++;
    }

    public void remove(int index) {
        Node current = first;
        Node prev = null;

        if (index == 0)
            first = current.next;
        else if (index == size)
        {
            for (int i = 0; i < index - 1; i++) {
                current.next = null;
            }
        }
        else if (index < size)
        {
            for (int i = 0; i < index; i++) {
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
        }
    }

    public T get(int index) {
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return (T) current.value;
    }
    public int size() {
        return size;
    }


    public Iterator<T> iterator() {
        return new MyLinkedListIterator<T>(first);
    }

    public void forEach(Consumer<? super T> action) {

    }

    public Spliterator<T> spliterator() {
        return null;
    }
}
