package LinkedList;

public class Node<T> {
    protected Node<T> next;
    protected Node<T> previous;
    private T element;

    protected Node(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        String toReturn = "Node { previous = ";
        if(previous == null) {
            toReturn += "null";
        } else {
            toReturn += previous.element;
        }
        toReturn += " | element = " + element + " | next = ";
        if(next == null) {
            toReturn += "null";
        } else {
            toReturn += next.element;
        }
        toReturn += "}";
        return toReturn;
    }

    public T getElement() {
        return element;
    }
}