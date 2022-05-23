package itis.homework.impl.linkedlist;

public interface LinkedListNode<T> {
    
    T getValue();
    
    void setValue(T value);
    
    LinkedListNode<T> getNext();
    
    void setNext(LinkedListNode<T> node);
}