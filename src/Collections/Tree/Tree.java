package Collections.Tree;

import Collections.IArray;
import Collections.Traversable;

public abstract class Tree<T extends Comparable<T>> implements IArray, ITree<T>, Traversable {
    protected TreeNode<T> root;

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return sizeRecursive(0, root);
    }

    public int sizeRecursive(int sizeR, TreeNode<T> startNode) {
        if (root == null) return 0;
        int size = sizeR;

        if (startNode.hasLeft()) {
            size += sizeRecursive(size, startNode.left);
        }
        if (startNode.hasRight()) {
            size += sizeRecursive(size, startNode.right);
        }

        return size + 1;
    }

    @Override
    public String getInOrder() {
        if (isEmpty()) return "";
        return internalGetInOrder(root).trim();
    }

    private String internalGetInOrder(TreeNode<T> startNode) {
        StringBuilder sb = new StringBuilder();

        if (startNode.hasLeft()) {
            sb.append(internalGetInOrder(startNode.left));
        }
        sb.append(startNode.getData()).append(" ");
        if (startNode.hasRight()) {
            sb.append(internalGetInOrder(startNode.right));
        }

        return sb.toString();
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

    protected TreeNode<T> findMin(TreeNode<T> node) {
        while (node.hasLeft()) {
            node = node.left;
        }
        return node;
    }

    public T getRootData() {
        return root.getData();
    }
}