package LinkedList;

public class LinkedList<T> implements IList<T> {
    private Node<T> head = null; // 0 element

    @Override
    public boolean add(T element) {
        Node<T> node = new Node<T>(element);
        if(head == null) {
            head = node;
        }
        else {
            Node<T> current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        return true;
    }

    @Override
    public void add(T element, int index) {
//            if (element == null) throw new NullPointerException();
//            if (index> currentSize-1) throw  new ArrayIndexOutOfBoundsException();
//            Node<T> linkElement = new Node<>(element);
//            currentSize++;
//            if (index == 0) {
//                linkElement.next = head;
//                head = linkElement;
//                return;
//            }
//            Node<T> insertAt = get(index-1);
//            linkElement.next = insertAt.next;
//            insertAt.next = linkElement;
    }

    @Override
    public Node<T> get(int index) {
        if(head == null) {
            return null;
        }
        int count = 0;
        Node<T> current = head;
        while(current.next != null) {
            if(count == index) {
                return current;
            }
            current = current.next;
            count++;
        }
        if(count == index) {
            return current;
        }
        return null;
    }

    @Override
    public int indexOf(T element) {
        if(head == null) {
            return -1;
        }
        int count = 0;
        Node<T> current = head;
        while(current.next != null) {
            if(current.equals(element)) {
                return count;
            }
            current = current.next;
            count++;
        }
        if(current.equals(element)) {
            return count;
        }
        return -1;
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
    public Node<T> remove(int index) {
        if(head == null) {
            return null;
        }

        int count = 0;
        Node<T> current = head;
        while(current.next != null) {
            if(count == index-1) {
                current.next = null; // TODO: fix me!
            }
            current = current.next;
            count++;
        }
        if(count == index) {
            return current;
        }
        return null;
    }

    @Override
    public Node<T> remove(T element) {
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
        return 0;
    }

    public Node<T> getHead() {
        return head;
    }

    @Override
    public String toString() {
        if(head == null) return "List is empty!";
        StringBuilder sb = new StringBuilder();

        Node<T> current = head;
        while(current.next != null) {
            sb.append(current).append("\n");
            current = current.next;
        }

        sb.append(current);

        return sb.toString();
    }
}
