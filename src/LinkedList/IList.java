package LinkedList;

public interface IList<T> {
    boolean add(T element);
    boolean add(T element, int index);
    boolean get(int index);
    int indexOf(T element);
    boolean contains(T element);
    boolean set(int index, T element);
    boolean remove(int index);
    boolean remove(T element);
    void clear();
    boolean isEmpty();
    int size();
}
