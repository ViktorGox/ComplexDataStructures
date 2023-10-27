package Collections.Graph;

import java.util.ArrayList;

public class Graph<T> {
    private final ArrayList<T> nodes;
    private final ArrayList<GraphConnection<T>> connections;

    public Graph() {
        nodes = new ArrayList<>();
        connections = new ArrayList<>();
    }

    public boolean addNode(T node) {
        if (node == null) return false;
        if (nodes.contains(node)) return false;
        if (!nodes.add(node)) return false;
        return true;
    }

    public boolean connect(T nodeA, T nodeB, int weight) {
        if (!nodes.contains(nodeA)) {
            throw new IllegalArgumentException("Node: " + nodeA + " does not exist! Cannot create connection for not existing nodes!");
        }
        if (!nodes.contains(nodeB)) {
            throw new IllegalArgumentException("Node: " + nodeB + " does not exist! Cannot create connection for not existing nodes!");

        }

        ArrayList<GraphConnection<T>> searchConnections = getConnectionsOf(nodeA, connections);
        ArrayList<GraphConnection<T>> filteredSearch = getConnectionsOf(nodeB, searchConnections);

        if (filteredSearch.size() != 0) return false;
        return connections.add(new GraphConnection<>(nodeA, nodeB, weight));
    }

    public ArrayList<GraphConnection<T>> getConnectionsOf(T node, ArrayList<GraphConnection<T>> connectionList) {
        ArrayList<GraphConnection<T>> foundConnections = new ArrayList<>();
        for (GraphConnection<T> connection : connectionList) {
            if (connection.getNodeA() == node || connection.getNodeB() == node) {
                foundConnections.add(connection);
            }
        }
        return foundConnections;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes +
                ", connections=" + connections +
                '}';
    }

    public String toGraphViz() {
        StringBuilder sb = new StringBuilder();
        for (GraphConnection<T> connection : connections) {
            sb.append(connection.getNodeA()).append(" -- ").append(connection.getNodeB()).append("\n");
        }
        return sb.toString();
    }
}
