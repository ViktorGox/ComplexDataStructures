package LinkedList;

public interface IList<T> {
    void add(T element);
    void add(T element, int index);
    Node<T> get(int index);
    int indexOf(T element);
    boolean contains(T element);
    boolean set(int index, T element);
    Node<T> remove(int index);
    Node<T> remove(T element);
    void clear();
    boolean isEmpty();
    int size();
}
