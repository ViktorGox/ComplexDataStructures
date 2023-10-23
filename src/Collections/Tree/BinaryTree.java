package Collections.Tree;

//TODO: https://chat.openai.com/share/9e5f87a0-4f03-46a7-a412-00039970dc17
//TODO: why i made the delete they way it is.
public class BinaryTree<T extends Comparable<T>> extends Tree<T> {

    public void add(T data) {
        TreeNode<T> newNode = new TreeNode<>(data);
        if (isEmpty()) {
            root = newNode;
            return;
        }

        TreeNode<T> currentNode = root;
        while (!currentNode.isLeaf()) {
            if (data.compareTo(currentNode.getData()) > 0) {
                if (currentNode.hasRight()) {
                    currentNode = currentNode.right;
                } else {
                    currentNode.right = newNode;
                    newNode.parent = currentNode;
                    return;
                }
            } else {
                if (currentNode.hasLeft()) {
                    currentNode = currentNode.left;
                } else {
                    currentNode.left = newNode;
                    newNode.parent = currentNode;
                    return;
                }
            }
        }

        if (data.compareTo(currentNode.getData()) > 0) {
            currentNode.right = newNode;
        } else {
            currentNode.left = newNode;
        }
        newNode.parent = currentNode;
    }

    @Override
    public boolean contains(T data) {
        return internalGetNode(data) != null;
    }

    private TreeNode<T> internalGetNode(T data) {
        if (isEmpty()) {
            return null;
        }

        TreeNode<T> currentNode = root;
        while (currentNode.getData() != data) {
            if (data.compareTo(currentNode.getData()) > 0) {
                if (currentNode.hasRight()) {
                    currentNode = currentNode.right;
                } else {
                    return null;
                }
            } else {
                if (currentNode.hasLeft()) {
                    currentNode = currentNode.left;
                } else {
                    return null;
                }
            }
        }
        return currentNode;
    }

    public T get(T data) {
        TreeNode<T> foundData = internalGetNode(data);
        if (foundData == null) return null;
        return foundData.getData();
    }

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
            removeMethodNode = null;
            return null;
        }

        TreeNode<T> replacementNode = null;

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
            TreeNode<T> successor = findMin(node.right);

            replacementNode = new TreeNode<>(successor.getData());
            replacementNode.right = internalRemove(node.right, successor.getData());
            replacementNode.left = node.left;
        }

        return (replacementNode != null) ? replacementNode : node;
    }
}