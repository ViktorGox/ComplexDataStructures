package LinkedList;

public class Node<T> {
    protected Node<T> next;
    private T element;

    protected Node(T element) {
        this.element = element;
    }
    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                '}';
    }
}
