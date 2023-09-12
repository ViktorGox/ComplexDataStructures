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

    /**
     * Add an element to a given index. If index is on index = size, the item will be added to the end.
     * @param data the data which will be stored. Does not accept null.
     * @param index Index the data will be assigned to. (0 to size)
     */
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
        Node<T> insertAt = getNodeAt(index - 1);
        node.next = insertAt.next;
        node.previous = insertAt;
        if(node.next != null) {
            node.next.previous = node;
        }
        insertAt.next = node;
    }

    /**
     * Finds node by index and returns the node itself.
     * @param index the index of the node (0 to size - 1)
     * @return the node.
     */
    private Node<T> getNodeAt(int index) {
        if (head == null) {
            throw new ArrayIndexOutOfBoundsException("List is empty!");
        }
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index + " is outside of the list's bounds");
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

    /**
     * Finds data by index and returns the data.
     * @param index the index of the data (0 to size - 1)
     * @return the data.
     */
    @Override
    public T get(int index) {
        return getNodeAt(index).getData();
    }

    /**
     * Finds the index of given data.
     * @param data the data that will be searched for. Does not accept null.
     * @return the index of the data, if nothing was found returns -1.
     */
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

    /**
     * Checks if given data is in the list.
     * @param data the data to be searched for. Null always returns false!
     * @return Whether it was found or not. Null always returns false!
     */
    @Override
    public boolean contains(T data) {
        if(data == null) return false;
        return indexOf(data) >= 0;
    }

    /**
     * Sets data to new given data if it exists.
     * @param index the index to be changed.
     * @param data  the data to be searched for.
     */
    @Override
    public void set(int index, T data) {
        if(data == null) return;
        getNodeAt(index).setData(data);
    }

    @Override
    public T remove(int index) {
        Node<T> nodeToRemove = getNodeAt(index);
        if(nodeToRemove == head) {
            head = null;
        }

        if(nodeToRemove.next != null) {
            if(nodeToRemove.previous == null) {
                head = nodeToRemove.next;
            } else {
                nodeToRemove.next.previous = nodeToRemove.previous;
            }
        }
        if(nodeToRemove.previous != null) {
            if(nodeToRemove.next != null) {
                nodeToRemove.previous.next = nodeToRemove.next;
            }
        }
        size--;
        return nodeToRemove.getData();
    }

    @Override
    public T remove(T data) {
        if(!contains(data))return null;
        return remove(indexOf(data));
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

    public T getHead() {
        return head.getData();
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
