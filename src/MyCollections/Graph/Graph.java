package MyCollections.Graph;

import java.util.ArrayList;

//https://stackoverflow.com/questions/2419353/make-arraylist-read-only
public class Graph<T> {
    private final ArrayList<GraphNode<T>> nodes;
    public Graph() {
        nodes = new ArrayList<>();
    }

    public boolean addNode(GraphNode<T> node) {
        if (node == null) return false;
        if (nodes.contains(node)) return false;
        if (!nodes.add(node)) return false;
        return true;
    }

    public GraphNode<T> addNode(T data) {
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
        GraphNode<T> searchedNode = new GraphNode<>(data);
        int indexOfNode = nodes.indexOf(searchedNode);
        if(indexOfNode == -1) return null;
        return nodes.get(indexOfNode);
    }

    public boolean contains(GraphNode<T> node) {
        return nodes.contains(node);
    }

    public boolean contains(T data) {
        return nodes.contains(new GraphNode<>(data));
    }

    public void connectMutual(T data1, T data2, int weight1, int weight2) {
        connectOneWay(data1, data2, weight1);
        connectOneWay(data2, data1, weight2);
    }

    public void connectOneWay(T start, T end, int weight) {
        GraphNode<T> node1 = getNode(start);
        GraphNode<T> node2 = getNode(end);
        node1.addConnection(node2, weight);
    }

    @Override
    public String toString() {
        return "Graph [" + nodes + ']';
    }

    public String traverseDepth() {
        return nodes.get(0).traverseDepth();
    }
}