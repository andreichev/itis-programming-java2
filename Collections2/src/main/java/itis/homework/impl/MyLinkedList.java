package itis.homework.impl;

import java.util.*;

public class MyLinkedList<T> implements List<T> {

    private static class Node {
        Object value;
        Node previous;
        Node next;

        public Node(Object value) {
            this.value = value;
            this.previous = null;
            this.next = null;
        }

        @Override
        public boolean equals(Object o) {
            return value.equals(o);
        }
    }

    Node head;
    Node tail;
    int size = 0;


    public int size() {
        return size;
    }

    public boolean add(T t) {
        if (head == null) {
            head = new Node(t);
            tail = head;
        } else {
            tail.next = new Node(t);
            tail.next.previous = tail;
            tail = tail.next;
        }
        size++;
        return true;
    }

    public boolean remove(Object o) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (size == 1) {
            clear();
            return true;
        }
        Node current = head;
        while (!current.equals(o)) {
            if(current.next == null) {
                throw new NoSuchElementException();
            }
            current = current.next;
        }
        if (current.value == null) {
            throw new NoSuchElementException();
        }
        Node pre = current.previous;
        Node next = current.next;

        if (pre == null) {
            head = next;
            head.previous = null;
        } else if(next == null) {
            tail = pre;
            tail.next = null;
        } else {
            pre.next = next;
            next.previous = pre;
        }
        size--;
        return true;
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        } else return false;
    }

    public T get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return (T) current.value;
    }
    public void clear() {
        size = 0;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator<T> iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void add(int index, T element) {

    }

    public T remove(int index) {
        return null;
    }

    public T set(int index, T element) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<T> listIterator() {
        return null;
    }

    public ListIterator<T> listIterator(int index) {
        return null;
    }

    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
