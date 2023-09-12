package LinkedList;

public interface IList<T> {
    void add(T element);
    void add(T element, int index);
    T get(int index);
    int indexOf(T element);
    boolean contains(T element);
    void set(int index, T element);
    T remove(int index);
    T remove(T element);
    void clear();
    boolean isEmpty();
    int size();
}
