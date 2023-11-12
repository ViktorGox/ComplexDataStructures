package MyCollections.Tree;

import MyCollections.IArray;
import MyCollections.Traversable;

public abstract class Tree<T extends Comparable<T>> implements IArray, ITree<T>, Traversable {
    protected TreeNode<T> root;
    protected TreeNode<T> removeMethodNode;
    protected boolean hasRemovedNode;

    protected void setRemoveMethodNode(TreeNode<T> removedNode) {
        if (!hasRemovedNode) {
            removeMethodNode = removedNode;
            hasRemovedNode = true;
        }
    }

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
            size += sizeRecursive(sizeR, startNode.left);
        }
        if (startNode.hasRight()) {
            size += sizeRecursive(sizeR, startNode.right);
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
        if (isEmpty()) return "";
        return internalGetPreOrder(root).trim();
    }

    private String internalGetPreOrder(TreeNode<T> startNode) {
        StringBuilder sb = new StringBuilder();

        sb.append(startNode.getData()).append(" ");

        if (startNode.hasLeft()) {
            sb.append(internalGetPreOrder(startNode.left));
        }

        if (startNode.hasRight()) {
            sb.append(internalGetPreOrder(startNode.right));
        }

        return sb.toString();
    }

    @Override
    public String getPostorder() {
        if (isEmpty()) return "";
        return internalGetPostOrder(root).trim();
    }

    private String internalGetPostOrder(TreeNode<T> startNode) {
        StringBuilder sb = new StringBuilder();

        if (startNode.hasLeft()) {
            sb.append(internalGetPostOrder(startNode.left));
        }

        if (startNode.hasRight()) {
            sb.append(internalGetPostOrder(startNode.right));
        }

        sb.append(startNode.getData()).append(" ");

        return sb.toString();
    }

    @Override
    public String graphViz() {
        return toGraphVizRecursive(root);
    }

    private String toGraphVizRecursive(TreeNode<T> start) {
        StringBuilder sb = new StringBuilder();
        if(start.hasLeft()) {
            sb.append(start.getData()).append(" -> ");
            sb.append(start.left.getData()).append("\n");
        }

        if(start.hasRight()) {
            sb.append(start.getData()).append(" -> ");
            sb.append(start.right.getData()).append("\n");
        }

        if(start.hasLeft()) {
            sb.append(toGraphVizRecursive(start.left));
        }

        if(start.hasRight()) {
            sb.append(toGraphVizRecursive(start.right));
        }

        return sb.toString();
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