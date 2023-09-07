package LinkedList;

public class LinkedList<T> implements IList<T> {
    private Node<T> head = null; // 0 element
    private Node<T> tail = null; // size - 1 element

    @Override
    public boolean add(T element) {
        Node<T> node = new Node<T>(element);
        if (head == null) {
            head = node;
        } else {
            Node<T> current = head;

            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
            node.setPrevious(current);
        }
        tail = node;
        return true;
    }

    @Override
    public boolean add(T element, int index) {
        return false;
    }

    @Override
    public boolean get(int index) {
        return false;
    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public boolean set(int index, T element) {
        return false;
    }

    @Override
    public boolean remove(int index) {
        return false;
    }

    @Override
    public boolean remove(T element) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    public Node<T> getHead() {
        return head;
    }
}
