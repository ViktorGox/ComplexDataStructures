package Collections.Tree;

import Collections.IArray;

//https://chat.openai.com/share/9e5f87a0-4f03-46a7-a412-00039970dc17
//TODO: delete method
public class BinaryTree<T extends Comparable<T>> implements IArray, ITree<T> {
    private TreeNode<T> root;
    private TreeNode<T> removeMethodNode;
    private boolean hasRemovedNode;

    private void setRemoveMethodNode(TreeNode<T> removedNode) {
        if (!hasRemovedNode) {
            removeMethodNode = removedNode;
            hasRemovedNode = true;
        }
    }

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
        return false;
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


    private TreeNode<T> findMin(TreeNode<T> node) {
        while (node.hasLeft()) {
            node = node.left;
        }
        return node;
    }

    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return 0;
    }

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

    public T getRootData() {
        return root.getData();
    }
}