package PathFinding;

public class AStarNode<T> implements Comparable<AStarNode<T>> {
    private final T destination;
    private final T origin;
    private final double costF;

    public AStarNode(T origin, T destination, double costF) {
        this.destination = destination;
        this.costF = costF;
        this.origin = origin;
    }

    public T getDestination() {
        return destination;
    }

    public double getCostF() {
        return costF;
    }

    public T getOrigin() {
        return origin;
    }

    @Override
    public int compareTo(AStarNode o) {
        if (this.costF > o.costF) {
            return 1;
        } else if (this.costF < o.costF) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return origin + " - " + destination + " for " + costF;
    }
}