package List;

import java.io.FileReader;
import java.util.List;
import java.util.LinkedList;

public class LinkedListHW<T> {
    public Node head;

    public LinkedListHW() {
        head = null;
    }

    public class Node<T> {
        public T data;
        public Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }
    //ileReader fileReader = new FileReader("yegor.txt");


    public void add(T data) {
        Node newNode = new Node(data);
        Node currentNode = head;

        if (head == null) {
            head = newNode;
        }
        else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }
    public void remove(T data) {
        Node currentNode = head;
        Node previousNode = null;
        while (currentNode.next != null) {
            if (currentNode.data == data) {
                if (currentNode == head) {
                    head = currentNode.next;
                } else {
                    previousNode.next = currentNode.next;
                }
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }
    public void print() {
        Node currentNode = head;
        if (head != null) {
            System.out.println(head.data);
        }
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            System.out.println(currentNode.data);
        }
    }
}

class MAin {
    public static void main(String[] args) {
        java.util.LinkedList<Object> list = new java.util.LinkedList<>();

        list.add("fdfgdgd");
        list.add("sfsfd");
        list.add("sfsdf");
        list.add("vxvsd");
        list.add("gsfds");

        //list.print();

        list.remove("hjhkj");

        System.out.println(list);

        //list.print();
    }
}
