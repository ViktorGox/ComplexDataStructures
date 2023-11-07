package PathFinding;

public class PathFindNode<T> implements Comparable<PathFindNode<T>> {
    private final T destination;
    private final T origin;
    private final double costF;

    public PathFindNode(T origin, T destination, double costF) {
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
    public int compareTo(PathFindNode o) {
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