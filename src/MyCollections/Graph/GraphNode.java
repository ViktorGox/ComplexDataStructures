package MyCollections.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphNode<T> {
    private final T data;
    private final ArrayList<GraphConnection<T>> connections;

    public GraphNode(T data) {
        this.data = data;
        this.connections = new ArrayList<>();
    }

    public void addConnection(GraphNode<T> node, int weight) {
        if (hasConnectionTo(node)) return;
        connections.add(new GraphConnection<>(node, weight));
    }

    public List<GraphConnection<T>> getConnections() {
        return Collections.unmodifiableList(connections);
    }

    public boolean hasConnectionTo(GraphNode<T> node) {
        for (GraphConnection<T> connection : connections) {
            if (connection.getNodeB().equals(node)) return true;
        }
        return false;
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
}
