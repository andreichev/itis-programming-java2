package itis.homework.impl;

import java.util.List;
import java.util.Iterator;

import java.util.Spliterator;

import java.util.function.Consumer;





public class MyLinkedList<T> implements List<T> {
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

    @Override

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

    @Override

    public void remove(int index) {

        int count = 0;

        Node firstRemove = null;

        Node lastRemove = null;

        Node checked = first;

        if(index >= size) {

            System.out.println("Invalid index");

        } else if (index == 0) {

            first.next = null;

            size--;

        } else {

            while(count != index - 1) {

                checked = checked.next;

                count++;

            }

            firstRemove = checked;

            lastRemove = checked.next.next;

            firstRemove.next = lastRemove;

            size--;

        }

    }

    @Override

    public void remove(T object) {

    }

    @Override

    public void remove() {

    }

    @Override

    public T get(int index) {

        Node current = first;

        for (int i = 0; i < index; i++) {

            current = current.next;

        }

        return (T) current.value;

    }

    @Override

    public int size() {

        return size;

    }

// Iterable

    @Override

    public Iterator<T> iterator() {

        return new MyLinkedListIterator<T>(first);

    }

    @Override

    public void forEach(Consumer<? super T> action) {

    }

    @Override

    public Spliterator<T> spliterator() {

        return null;

    }
//
}
