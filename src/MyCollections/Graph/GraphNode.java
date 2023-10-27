package MyCollections.Graph;

import java.util.ArrayList;

public class GraphNode<T> {
    private final T data;
    private final ArrayList<GraphConnection<T>> connections;

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
        return "GraphNode{" +
                "data=" + data +
                ", connections=" + connections +
                '}';
    }

    public String toStringData() {
        return data.toString();
    }

    public String traverseDepth() {
        return traverseDepthRecursive(this);
    }

    private String traverseDepthRecursive(GraphNode<T> start) {
        if(start == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(start.data).append(", ");

        for (GraphConnection<T> connection : start.connections) {
            sb.append(traverseDepthRecursive(connection.getDestination()));
        }

        return sb.toString();
    }
}
