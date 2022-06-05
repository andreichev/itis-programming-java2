package MyLinkedList;
//import com.company.Collection;

public interface MyList<T> extends Collection, Iterable<T> {
    void add(T element);
    void remove(int index);
    void remove(T Object);
    void remove();
    T get(int index);
}
