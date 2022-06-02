package itis.homework.impl;

import java.util.List;

public class MyLinkedList<T> implements List<T> {
package Impl;

import base.MyList;

public class MyLinkedListImpl<T> implements MyList<T> {
    static class Node {
        Node next;
        Object value;
        public Node (Object value) {
            this.value = value;
            this.next = null;
        }
    }
    int size = 0;
    Node first;
    Node last;

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
        Node preDel = null;
        Node pastDel = null;
        Node lastVisited = first;
        int count = 0;
        if (index == 0) {
            first.next = null;
            size--;
        } else {
            while(count != index - 1) {
              lastVisited = lastVisited.next;
              count++;
            }
            preDel = lastVisited;
            pastDel = lastVisited.next.next;
            preDel.next = pastDel;
            size--;
        }

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


}

}
