package Collections.Tree.AVL;

import Collections.IArray;
import Collections.Traversable;
import Collections.Tree.ITree;

public class AVLTree<T extends Comparable<T>> implements IArray, ITree<T>, Traversable {

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String getInOrder() {
        return null;
    }

    @Override
    public String getPreorder() {
        return null;
    }

    @Override
    public String getPostorder() {
        return null;
    }

    @Override
    public String graphViz() {
        return null;
    }

    @Override
    public void add(T data) {

    }

    @Override
    public boolean contains(T data) {
        return false;
    }

    @Override
    public T get(T data) {
        return null;
    }

    @Override
    public T remove(T data) {
        return null;
    }
}