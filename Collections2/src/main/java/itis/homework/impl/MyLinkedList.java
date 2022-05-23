package itis.homework.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<T> implements List<T> {


    private class Node<T>{
        T value;
        Node<T> next;
        Node(T value){
            this.value = value;
            this.next=null;
        }
    }
    private Node<T> head = null;
    @Override
    public int size() {
        Node<T> p;
        int size=0;
        for(p=head;p!=null;p=p.next){
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size()==0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        if(isEmpty()){
            return false;
        }
        Node<T> p;
        for(p=head;p!=null;p=p.next){
            if(p.value.equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {


        if(isEmpty()){
            head= new Node<>(t);

        }else{
            Node<T> p=head;
            Node<T> node=new Node<>(t);
            while(p.next!=null){
                p=p.next;
            }
            p.next=node;
            node.next=null;
        }

        return true;

    }

    @Override
    public boolean remove(Object o) {
        Node<T> p=head,p1=null;
        boolean have=false;
        if(isEmpty()){
            return false;
        }
        while(p!=null){
            if(p.value.equals(o)){
                if(p1==null){
                    head=head.next;
                }else{
                    p1.next=p.next;
                }
                have=true;
            }
            p1=p;
            p=p.next;
        }
        return have;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        int i=-1;
        if(isEmpty()){
            return null;
        }
        if(index<0||index>size()){
            return null;
        }
        Node<T> p=head;
        while(p!=null){
            i++;
            if(i==index){
                return p.value;

            }

            p=p.next;
        }
        return null;
    }

    @Override
    public T set(int index, T element) {
        int i=-1;
        if(isEmpty()){
            add(element);
            return null;
        }
        if(index<0||index>size()){
            return null;
        }
        Node<T> p=head;
        T o=null;
        while(p!=null){
            i++;
            if(i==index){
                o=p.value;
                p.value=element;
                return o;
            }
            p=p.next;
        }
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        if(isEmpty()){
            return null;
        }
        if(index<0||index>size()){
            return null;
        }
        Node<T> p=head,p1=null;
        int i=-1;
        while(p!=null){
            i++;
            if(i==index){
                if(p1==null){
                    head=head.next;
                }else{
                    p1.next=p.next;
                }
                return p.value;
            }
            p1=p;
            p=p.next;
        }
        return null;

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
