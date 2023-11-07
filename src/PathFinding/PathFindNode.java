package PathFinding;

public class PathFindNode<T> implements Comparable<PathFindNode<T>> {
    private final T destination;
    private T origin;
    private double cost;

    public PathFindNode(T origin, T destination, double cost) {
        this.destination = destination;
        this.cost = cost;
        this.origin = origin;
    }

    public T getDestination() {
        return destination;
    }

    public double getCost() {
        return cost;
    }

    public T getOrigin() {
        return origin;
    }

    @Override
    public int compareTo(PathFindNode o) {
        if (this.cost > o.cost) {
            return 1;
        } else if (this.cost < o.cost) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return origin + " - " + destination + " for " + cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setOrigin(T origin) {
        this.origin = origin;
    }
}