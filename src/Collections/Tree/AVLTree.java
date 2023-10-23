package Collections.Tree;

import Utilities.Tuple;

// TODO: https://www.happycoders.eu/algorithms/avl-tree-java/ for the rotate
public class AVLTree<T extends Comparable<T>> extends Tree<T> {
    @Override
    public void add(T data) {
        Tuple<TreeNode<T>, TreeNode<T>> result = getNodeAndParentRecursive(root, root, data);
        TreeNode<T> node = result.first;
        TreeNode<T> parent = result.second;

        if (parent == null) {
            root = new TreeNode<>(data);
            return;
        }

        if (node != null) return; // Duplicates not allowed.

        node = new TreeNode<>(data);

        if (data.compareTo(parent.getData()) < 0) {
            parent.left = node;
            parent.left.parent = parent;
        } else if (data.compareTo(parent.getData()) > 0) {
            parent.right = node;
            parent.right.parent = parent;
        }

        root = reBalanceRecursive(parent);
    }

    @Override
    public boolean contains(T data) {
        return get(data) != null;
    }

    @Override
    public T get(T data) {
        return getNode(data).getData();
    }

    public TreeNode<T> getNode(T data) { // TODO: MAKE PRIVATE
        return getNodeAndParentRecursive(root, root, data).first;
    }

    /**
     * TODO: Made it this way so that I can use this for the add method. Without giving the parent, I need to repeat this code
     * in the add method, to get the parent. This way I get the parent. Also I made the Tuple, so that I don't need to
     * create a generic array[].
     *
     * @param startNode
     * @param parent
     * @param data
     * @return
     */
    private Tuple<TreeNode<T>, TreeNode<T>> getNodeAndParentRecursive(TreeNode<T> startNode, TreeNode<T> parent, T data) {
        if (startNode == null) return new Tuple<>(null, parent);

        if (data.compareTo(startNode.getData()) < 0) {
            return getNodeAndParentRecursive(startNode.left, startNode, data);
        } else if (data.compareTo(startNode.getData()) > 0) {
            return getNodeAndParentRecursive(startNode.right, startNode, data);
        } else {
            return new Tuple<>(startNode, parent);
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