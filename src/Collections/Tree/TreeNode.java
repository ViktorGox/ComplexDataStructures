package Collections.Tree;

public class TreeNode<T extends Comparable<T>> {

//    protected TreeNode<T> parent;
    protected TreeNode<T> left;
    protected TreeNode<T> right;
    private final T data;

    protected TreeNode(T data) {
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

    public int getHeight() {
        return getHeightRecursive(this);
    }

    private int getHeightRecursive(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeightRecursive(node.left);
        int rightHeight = getHeightRecursive(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public String toString() {
        return "data = " + getData() +
                ", left = " + ((left != null) ? left.getData() : null) +
                ", right = " + ((right != null) ? right.getData() : null);
    }
}