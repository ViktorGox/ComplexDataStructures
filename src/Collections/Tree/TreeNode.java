package Collections.Tree;

public class TreeNode<T> {
    protected TreeNode<T> parent;
    protected TreeNode<T> left;
    protected TreeNode<T> right;
    private final T data;

    protected TreeNode(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }

    public boolean isRoot() {
        return parent == null;
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
}