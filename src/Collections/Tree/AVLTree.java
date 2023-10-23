package Collections.Tree;

// TODO: https://www.happycoders.eu/algorithms/avl-tree-java/ for the rotate
//TODO: I tried to make it so that you find the parent, in the add, to avoid duplication of get and the add,
// I made a tuple to save the parent, of the new nodes location. But I realized it wont work this way. Because if I cant
// fix the tree upwards, as I only have the parent. I'd have to do extra work to go up the parents. This way ends up better.
public class AVLTree<T extends Comparable<T>> extends Tree<T> {

    @Override
    public void add(T data) {
        root = addRecursive(data, root);
    }

    public TreeNode<T> addRecursive(T data, TreeNode<T> start) {
        if (start == null) {
            return new TreeNode<T>(data);
        }
        if (data.compareTo(start.getData()) < 0) {
            start.left = addRecursive(data, start.left);
        } else if (data.compareTo(start.getData()) > 0) {
            start.right = addRecursive(data, start.right);
        } else {
            return start;
        }
        return reBalanceRecursive(start);
    }

    @Override
    public boolean contains(T data) {
        return get(data) != null;
    }

    @Override
    public T get(T data) {
        return getNode(data).getData();
    }

    private TreeNode<T> getNode(T data) {
        return getNodeRecursive(root, data);
    }

    private TreeNode<T> getNodeRecursive(TreeNode<T> startNode, T data) {
        if (startNode == null) return null;

        if (data.compareTo(startNode.getData()) < 0) {
            return getNodeRecursive(startNode.left, data);
        } else if (data.compareTo(startNode.getData()) > 0) {
            return getNodeRecursive(startNode.right, data);
        } else {
            return startNode;
        }
    }

    @Override
    public T remove(T data) {
        return null;
    }

    private TreeNode<T> reBalanceRecursive(TreeNode<T> node) {
        int balance = getBalance(node);

        if (balance > 1) {
            if (getBalance(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }
        if (balance < -1) {
            if (getBalance(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }
        return node;
    }

    private int getBalance(TreeNode<T> node) {
        if (node == null) return 0;
        int leftHeight = 0;
        int rightHeight = 0;
        if (node.hasLeft()) {
            leftHeight = node.left.getHeight();
        }
        if (node.hasRight()) {
            rightHeight = node.right.getHeight();
        }
        return leftHeight - rightHeight;
    }

    private TreeNode<T> rotateRight(TreeNode<T> node) {
        TreeNode<T> leftNode = node.left;
        TreeNode<T> centerNode = leftNode.right;
        leftNode.right = node;
        node.left = centerNode;

        return leftNode;
    }

    private TreeNode<T> rotateLeft(TreeNode<T> node) {
        TreeNode<T> rightNode = node.right;
        TreeNode<T> centerNode = rightNode.left;
        rightNode.left = node;
        node.right = centerNode;

        return rightNode;
    }
}