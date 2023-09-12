package LinkedList;

public class LinkedList<T> implements IList<T> {
    private Node<T> head = null; // 0 element
    private int size;

    /**
     * Add an element at the last index of the list.
     * @param data the data which will be stored. Does not accept null.
     */
    @Override
    public void add(T data) {
        if(data == null) throw new IllegalArgumentException("Provided data must not be null!");
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
            if (current == head) {
                current.next.previous = head;
            } else {
                current.next.previous = current;
            }
        }
        size++;
    }

    @Override
    public void add(T data, int index) {
        if(isEmpty()) {
            if(index == 0) {
                add(data);
                return;
            }
        }

        if(index > size) {
            throw new ArrayIndexOutOfBoundsException("Cannot add data at position " + index + " when size is " + size);
        }
        Node<T> node = new Node<>(data);
        size++;
        if (index == 0) {
            node.next = head;
            head = node;
            head.next.previous = head;
            return;
        }
        Node<T> insertAt = get(index - 1);
        node.next = insertAt.next;
        node.previous = insertAt;
        if(node.next != null) {
            node.next.previous = node;
        }
        insertAt.next = node;
    }

    @Override
    public Node<T> get(int index) {
        if (head == null || index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("List is empty!");
        }
        int count = 0;
        Node<T> current = head;
        while (current.next != null) {
            if (count == index) {
                return current;
            }
            current = current.next;
            count++;
        }
        return current;
    }

    @Override
    public int indexOf(T data) {
        if(data == null) {
            throw new IllegalArgumentException("Data in list cannot be null!");
        }
        if (head == null) {
            return -1;
        }
        int count = 0;
        Node<T> current = head;
        while (current.next != null) {
            if (current.getData().equals(data)) {
                return count;
            }
            current = current.next;
            count++;
        }
        if (current.getData().equals(data)) {
            return count;
        }
        return -1;
    }

    @Override
    public boolean contains(T data) {
        return false;
    }

    @Override
    public boolean set(int index, T data) {
        return false;
    }

    @Override
    public Node<T> remove(int index) {
        if (head == null) {
            return null;
        }

        int count = 0;
        Node<T> current = head;
        while (current.next != null) {
            if (count == index - 1) {
                current.next = null; // TODO: fix me!
            }
            current = current.next;
            count++;
        }
        if (count == index) {
            return current;
        }
        return null;
    }

    @Override
    public Node<T> remove(T data) {
        return null;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    public Node<T> getHead() {
        return head;
    }

    @Override
    public String toString() {
        if (head == null) return "List is empty!";
        StringBuilder sb = new StringBuilder();

        Node<T> current = head;
        while (current.next != null) {
            sb.append(current).append("\n");
            current = current.next;
        }

        sb.append(current);

        return sb.toString();
    }
}
