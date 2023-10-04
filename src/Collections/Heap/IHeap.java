package Collections.Heap;

public interface IHeap<T> {
    void push(T value);
    T peek();
    T pop();
    void buildHeap();
}
