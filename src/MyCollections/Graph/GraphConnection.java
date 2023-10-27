package MyCollections.Graph;

public class GraphConnection<T> {
    private final GraphNode<T> destination;
    private final int weight;

    public GraphConnection(GraphNode<T> destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public GraphNode<T> getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "{dest:" + destination.toStringData() + " w:" + weight + "}";
    }
}