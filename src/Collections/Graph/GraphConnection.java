package Collections.Graph;

public class GraphConnection<T> {
    private final T nodeA;
    private final T nodeB;
    private final int weight;

    public GraphConnection(T nodeA, T nodeB, int weight) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.weight = weight;
    }

    public T getNodeA() {
        return nodeA;
    }

    public T getNodeB() {
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