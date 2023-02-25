package ru.itis.collections.list;

public class CoolLinkedList<T> implements CoolList<T> {
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int count = 0;

    @Override
    public void add(T x) {
        if(last == null) {
            first = new Node<>(x);
            last = first;
            count++;
            return;
        }
        Node<T> node = new Node<>(x);
        last.next = node;
        last = node;
        count++;
    }

    @Override
    public void add(T x, int index) {
        // TODO: Implement
    }

    @Override
    public void set(T x, int index) {
        // TODO: Implement
    }

    @Override
    public T get(int index) {
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    @Override
    public void remove(int index) {
        // TODO: Implement
    }

    @Override
    public void clear() {
        // TODO: Implement
    }

    @Override
    public int size() {
        return count;
    }
}
