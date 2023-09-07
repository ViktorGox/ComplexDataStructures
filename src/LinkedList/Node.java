package LinkedList;

public class Node<T> {
    private Node<T> next;
    private Node<T> previous;
    private T element;

    protected Node(T element) {
        this.element = element;
    }

    protected void setNext(Node<T> next) {
        this.next = next;
    }

    protected void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    protected Node<T> getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", previous=" + previous +
                ", element=" + element +
                '}';
    }
}
