package MyCollections.Graph;

public class GraphConnection<T> {
    private final GraphNode<T> nodeA;
    private final GraphNode<T> nodeB;
    private final int weight;

    public GraphConnection(GraphNode<T> nodeA, GraphNode<T> nodeB, int weight) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.weight = weight;
    }

    public GraphNode<T> getNodeA() {
        return nodeA;
    }

    public GraphNode<T> getNodeB() {
        return nodeB;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "{A:" + nodeA + " B:" + nodeB + " w:" + weight + "}";
    }
}