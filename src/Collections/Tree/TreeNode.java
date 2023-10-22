package Collections.Tree;

public class TreeNode<T extends Comparable<T>> {

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

//    public int findDepth(int data) {
//        return findDepth(root, data, 0);
//    }
//
//    private int findDepth(Node node, int data, int depth) {
//        if (node == null) {
//            return -1; // Node not found
//        }
//
//        if (data == node.data) {
//            return depth;
//        } else if (data < node.data) {
//            return findDepth(node.left, data, depth + 1);
//        } else {
//            return findDepth(node.right, data, depth + 1);
//        }
//    }


    @Override
    public String toString() {
        return "data = " + getData() +
                ", parent = " + ((parent != null) ? parent.getData() : null) +
                ", left = " + ((left != null) ? left.getData() : null) +
                ", right = " + ((right != null) ? right.getData() : null);
    }
}
