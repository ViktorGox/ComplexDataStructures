package Collections.Tree.AVL;

public class AVLTreeNode<T> {

    protected AVLTreeNode<T> parent;
    protected AVLTreeNode<T> left;
    protected AVLTreeNode<T> right;
    private final T data;

    protected AVLTreeNode(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }
    public boolean isLeaf() {
        return left == null && right == null;
    }
    public boolean hasLeft() {
        return left != null;
    }
    public boolean hasRight() {
        return right != null;
    }

    private int internalRecursiveGetDepth(AVLTreeNode<T> start) {
        if (start == null) {
            return 0;
        }

        int leftHeight = internalRecursiveGetDepth(start.left);
        int rightHeight = internalRecursiveGetDepth(start.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int getDepth() {
        return internalRecursiveGetDepth(this);
    }
}
