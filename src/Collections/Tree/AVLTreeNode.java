package Collections.Tree;

public class AVLTreeNode<T> extends TreeNode<T>{

    protected AVLTreeNode(T data) {
        super(data);
    }

    private int internalRecursiveGetDepth(TreeNode<T> start) {
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
