package MyCollections.Graph;

public class GraphConnection<T> {
    private final GraphNode<T> nodeB;
    private final int weight;

    public GraphConnection(GraphNode<T> nodeB, int weight) {
        this.nodeB = nodeB;
        this.weight = weight;
    }

    public GraphNode<T> getNodeB() {
        return nodeB;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "{dest:" + nodeB.toStringData() + " w:" + weight + "}";
    }
}