package MyCollections.Tree;

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
        return getNode(data) != null;
    }

    public TreeNode<T> getNode(T data) {
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
        root = internalRemove(root, data);
        hasRemovedNode = false;
        if (removeMethodNode != null) {
            return removeMethodNode.getData();
        }
        return null;
    }

    private TreeNode<T> internalRemove(TreeNode<T> node, T data) {
        if (node == null) {
            return null;
        }

        int compareResult = data.compareTo(node.getData());

        if (compareResult < 0) {
            node.left = internalRemove(node.left, data);
        } else if (compareResult > 0) {
            node.right = internalRemove(node.right, data);
        } else {
            setRemoveMethodNode(node);

            if (!node.hasLeft()) {
                return node.right;
            } else if (!node.hasRight()) {
                return node.left;
            }

            TreeNode<T> replacementNode = new TreeNode<>(findMin(node.right).getData());
            replacementNode.right = internalRemove(node.right, replacementNode.getData());
            replacementNode.left = node.left;

            return reBalanceRecursive(replacementNode);
        }

        return reBalanceRecursive(node);
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