package MyCollections.Graph;

import java.util.ArrayList;

public class GraphNode<T> {
    private final T data;
    private final ArrayList<GraphConnection<T>> connections;
    private final ArrayList<GraphNode<T>> traversalArray = new ArrayList<>();

    public GraphNode(T data) {
        this.data = data;
        this.connections = new ArrayList<>();
    }

    protected void addConnection(GraphNode<T> node, int weight) {
        if (hasConnectionTo(node)) return;
        connections.add(new GraphConnection<>(node, weight));
    }

    public GraphConnection<T>[] getConnections() {
        GraphConnection<T>[] array = (GraphConnection<T>[]) new GraphConnection[connections.size()];
        return connections.toArray(array);
    }

    public boolean hasConnectionTo(GraphNode<T> node) {
        for (GraphConnection<T> connection : connections) {
            if (connection.getDestination().equals(node)) return true;
        }
        return false;
    }

    public boolean hasConnectionTo(T data) {
        return hasConnectionTo(new GraphNode<>(data));
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof GraphNode<?>)) return false;
        GraphNode<T> transferred = (GraphNode<T>) obj;
        if (this.data.equals(transferred.data)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return data.toString();
    }
    public T getData() {
        return data;
    }

    public String toStringData() {
        return data.toString();
    }

    public GraphNode<T>[] traverseDepth() {
        traverseDepthRecursive(this);
        GraphNode<T>[] array = (GraphNode<T>[]) new GraphNode[traversalArray.size()];
        return traversalArray.toArray(array);
    }

    private void traverseDepthRecursive(GraphNode<T> start) {
        if (start == null) return;
        if (traversalArray.contains(start)) return;
        traversalArray.add(start);

        for (GraphConnection<T> connection : start.connections) {
            traverseDepthRecursive(connection.getDestination());
        }
    }
}
