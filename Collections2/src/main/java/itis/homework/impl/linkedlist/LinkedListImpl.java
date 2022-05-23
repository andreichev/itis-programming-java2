package itis.homework.impl.linkedlist;

public class LinkedListImpl<T> implements LinkedList<T> {
    
    private LinkedListNodeImpl<T> firstNode;
    private int size;
    
    public T get(int index) {
        return getNodeByIndex(index).getValue();
    }

    public void add(T value) {
        if (size == 0)
            firstNode = new LinkedListNodeImpl<T>(value);
        else
            getNodeByIndex(size - 1).setNext(new LinkedListNodeImpl<T>(value));
        
        size++;
    }
    
    public void insert(int index, T value) {
        LinkedListNodeImpl<T> linkedListNode = new LinkedListNodeImpl<T>(value);
        
        if (index == 0) {
            linkedListNode.setNext(firstNode);
            firstNode = linkedListNode;
        }
        else if (index == size) {
            add(value);
            return;
        }
        else {
            LinkedListNodeImpl<T> nodeLeft = getNodeByIndex(index - 1);
            LinkedListNodeImpl<T> nodeRight = (LinkedListNodeImpl<T>) nodeLeft.getNext();
            
            nodeLeft.setNext(linkedListNode);
            linkedListNode.setNext(nodeRight);
        }
        
        size++;
    }
    
    public void remove(int index) {
        LinkedListNodeImpl<T> nodeLeft = getNodeByIndex(index - 1);
        
        if (index == size - 1) {
            nodeLeft.setNext(null);
        }
        else {
            LinkedListNodeImpl<T> nodeToRemove = (LinkedListNodeImpl<T>) nodeLeft.getNext();
            LinkedListNodeImpl<T> nodeRight = (LinkedListNodeImpl<T>) nodeToRemove.getNext();
            
            nodeLeft.setNext(nodeRight);
        }
        
        size--;
    }
    
    public int size() {
        return size;
    }
    
    private LinkedListNodeImpl<T> getNodeByIndex(int index) {
        LinkedListNodeImpl<T> currentNode = firstNode;
        
        for (int i = 0; i < index; i++) {
            currentNode = (LinkedListNodeImpl<T>) currentNode.getNext();
        }
        
        return currentNode;
    }
}
