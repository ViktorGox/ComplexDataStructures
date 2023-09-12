package LinkedList;

public class Node<T> {
    protected Node<T> next;
    protected Node<T> previous;
    private T data;

    protected Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String toReturn = "Node { previous = ";
        if (previous == null) {
            toReturn += "null";
        } else {
            toReturn += previous.data;
        }
        toReturn += " | data = " + data + " | next = ";
        if (next == null) {
            toReturn += "null";
        } else {
            toReturn += next.data;
        }
        toReturn += "}";
        return toReturn;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}