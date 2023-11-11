package MyCollections.Tree;

public interface ITree<T extends Comparable<T>> {
    void add(T data);
    boolean contains(T data);
    T remove(T data);
}
