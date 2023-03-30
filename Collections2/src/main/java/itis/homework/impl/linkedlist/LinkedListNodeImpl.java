package itis.homework.impl.linkedlist;

public class LinkedListNodeImpl<T> implements LinkedListNode<T> {
    
    private T value;
    private LinkedListNode<T> next;
    
    public LinkedListNodeImpl(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
    
    public void setValue(T value) {
        this.value = value;
    }
    
    public LinkedListNode<T> getNext() {
        return next;
    }
    
    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }
}
