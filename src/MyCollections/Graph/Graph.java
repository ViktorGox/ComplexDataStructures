package MyCollections.Graph;

import java.util.ArrayList;

public class Graph<T> {
    private final ArrayList<GraphNode<T>> nodes;
    public Graph() {
        nodes = new ArrayList<>();
    }

    /**
     * <b>BEWARE! ALSO ADDS ITS CONNECTIONS! You might accidentally add an entire other graph!
     * Use addNode(T data) instead if you want to add only the data.</b>
     * <p></p>
     * Add a new node to this current node.
     * <p></p>
     */
    public boolean addNode(GraphNode<T> node) {
        if(node == null) {
            return false;
        }
        if (nodes.contains(node)) {
            return false;
        }
        nodes.add(node);
        return true;
    }

    public GraphNode<T> addNode(T data) {
        if(data == null) {
            return null;
        }
        GraphNode<T> newNode = new GraphNode<>(data);
        if (addNode(newNode)) {
            return newNode;
        }
        return null;
    }

    public GraphNode<T>[] getNodes() {
        GraphNode<T>[] array = (GraphNode<T>[]) new GraphNode[nodes.size()];
        return nodes.toArray(array);
    }

    public GraphNode<T> getNode(T data) {
        if (data == null) {
            return null;
        }
        GraphNode<T> searchedNode = new GraphNode<>(data);
        int indexOfNode = nodes.indexOf(searchedNode);
        if (indexOfNode == -1) {
            return null;
        }
        return nodes.get(indexOfNode);
    }

    public boolean contains(GraphNode<T> node) {
        return nodes.contains(node);
    }

    public boolean contains(T data) {
        if(data == null) {
            return false;
        }
        return nodes.contains(new GraphNode<>(data));
    }

    public boolean connectMutual(T point1, T point2, double weight1, double weight2) {
        boolean firstWay = connectOneWay(point1, point2, weight1);
        if(!firstWay) return false;
        boolean secondWay = connectOneWay(point2, point1, weight2);
        if(!secondWay) {
            throw new IllegalStateException("Somehow the first connection was established successfully, but the second failed.");
        }
        return true;
    }

    public boolean connectOneWay(T start, T destination, double weight) {
        GraphNode<T> node1 = getNode(start);
        GraphNode<T> node2 = getNode(destination);
        if (node1 == null || node2 == null) {
            return false;
        }
        node1.addConnection(node2, weight);
        return true;
    }

    public boolean disconnectMutual(T point1, T point2) {
        boolean firstWay = disconnectOneWay(point1, point2);
        if(!firstWay) return false;
        boolean secondWay = disconnectOneWay(point2, point1);
        if(!secondWay) {
            throw new IllegalStateException("Somehow the first connection was removed successfully, but the second failed.");
        }
        return true;
    }

    public boolean disconnectOneWay(T start, T destination) {
        GraphNode<T> node1 = getNode(start);
        GraphNode<T> node2 = getNode(destination);
        if (node1 == null || node2 == null) {
            return false;
        }
        node1.removeConnection(node2);
        return true;
    }

    @Override
    public String toString() {
        return nodes.toString();
    }

    public GraphNode<T>[] traverseDepthFrom(T data) {
        if(data == null) {
            return null;
        }
        return traverseDepthFrom(getNode(data));
    }

    public GraphNode<T>[] traverseDepthFrom(GraphNode<T> startNode) {
        if(startNode == null) {
            return null;
        }
        return startNode.traverseDepth();
    }

    public GraphNode<T>[] traverseDepthFromExcluded(T data) {
        if(data == null) {
            return null;
        }
        GraphNode<T>[] traverseResult = traverseDepthFrom(data);
        ArrayList<GraphNode<T>> traverseExcluded = new ArrayList<>(nodes);

        removeDuplicates(traverseExcluded, traverseResult);

        GraphNode<T>[] array = (GraphNode<T>[]) new GraphNode[traverseExcluded.size()];
        return traverseExcluded.toArray(array);
    }

    public String toGraphViz() {
        StringBuilder sb = new StringBuilder();

        for (GraphNode<T> node : nodes) {
            GraphConnection<T>[] nodeConnections = node.getConnections();
            if (nodeConnections.length == 0) {
                sb.append(node.getData()).append("\n");
            }
            for (GraphConnection<T> connection : nodeConnections) {
                sb.append(node.getData()).append(" -> ")
                        .append(connection.getDestination())
                        .append(" [label=") // remove this to make graphViz generate all of the connections.
                        .append(connection.getWeight()) // and remove this
                        .append("]\n"); // and the ]
            }
        }
        return sb.toString();
    }

    private boolean removeDuplicates(ArrayList<GraphNode<T>> fullList, GraphNode<T>[] toRemove) {
        boolean changed = false;
        for (GraphNode<T> tGraphNode : toRemove) {
            fullList.remove(tGraphNode);
            changed = true;
        }
        return changed;
    }

    public void copyNodeData(Graph<T> graphWithNodes) {
        if(graphWithNodes == null) {
            return;
        }
        for (GraphNode<T> node : graphWithNodes.getNodes()) {
            addNode(node.getData());
        }
    }
}