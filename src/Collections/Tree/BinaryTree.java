package Collections.Tree;

public class BinaryTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public void add(T data) {
        TreeNode<T> newNode = new TreeNode<>(data);
        if (isEmpty()) {
            root = newNode;
            return;
        }

        TreeNode<T> currentNode = root;
        while (!currentNode.isLeaf()) {
            if(data.compareTo(currentNode.getData()) > 0) {
                if(currentNode.hasRight()) {
                    currentNode = currentNode.right;
                } else {
                    currentNode.right = newNode;
                    return;
                }
            } else {
                if(currentNode.hasLeft()) {
                    currentNode = currentNode.left;
                } else {
                    currentNode.left = newNode;
                    return;
                }
            }
        }

        if(data.compareTo(currentNode.getData()) > 0) {
            currentNode.right = newNode;
        } else {
            currentNode.left = newNode;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public String getAGraphString() {
        if(isEmpty()) return "";
        return getGraphStringRecursiveA_WorkingWay(root);
    }

    public String getInOrder() {
        if(isEmpty()) return "";
        return internalGetInOrder(root).trim();
    }

    private String internalGetInOrder(TreeNode<T> startNode) {
        StringBuilder sb = new StringBuilder();

        if(startNode.hasLeft()) {
            sb.append(internalGetInOrder(startNode.left));
        }
        sb.append(startNode.getData()).append(" ");
        if(startNode.hasRight()) {
            sb.append(internalGetInOrder(startNode.right));
        }

        return sb.toString();
    }



    public String getGraphStringRecursiveA_WorkingWay(TreeNode<T> startNode) {
        StringBuilder sb = new StringBuilder();

        if(startNode.hasLeft()) {
            sb.append(getGraphStringRecursiveA_WorkingWay(startNode.left)).append(" ");
        }
        if(startNode.hasRight()) {
            sb.append(getGraphStringRecursiveA_WorkingWay(startNode.right)).append(" ");
        }

        sb.append(startNode.getData());
        return sb.toString();
    }
}
