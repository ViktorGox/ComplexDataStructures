package MyCollections.Graph;

public class GraphConnection<T> {
    private final GraphNode<T> destination;
    private final double weight;

    public GraphConnection(GraphNode<T> destination, double weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public GraphNode<T> getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "{dest:" + destination.toStringData() + " w:" + weight + "}";
    }
}