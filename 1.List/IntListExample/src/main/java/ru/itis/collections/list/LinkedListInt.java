package ru.itis.collections.list;

public class LinkedListInt implements IntList {
    private static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node first;
    private Node last;
    private int count = 0;

    @Override
    public void add(int x) {
        if(last == null) {
            first = new Node(x);
            last = first;
            count++;
            return;
        }
        Node node = new Node(x);
        last.next = node;
        last = node;
        count++;
    }

    @Override
    public void add(int x, int index) {
        // TODO: Implement
    }

    @Override
    public void set(int x, int index) {
        // TODO: Implement
    }

    @Override
    public int get(int index) {
        Node node = first;
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
