package MyCollections.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public List<GraphNode<T>> getNodes() {
        return Collections.unmodifiableList(nodes);
    }

    public GraphNode<T> getNode(T data) {
        return nodes.get(nodes.indexOf(new GraphNode<>(data)));
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
}