package PathFinding.Nodes;

public class BaseNode<T> {
    protected final T destination;
    protected T origin;
    protected double cost;

    public BaseNode(T destination, T origin, double cost) {
        this.destination = destination;
        this.origin = origin;
        this.cost = cost;
    }

    public T getDestination() {
        return destination;
    }

    public T getOrigin() {
        return origin;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setOrigin(T origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return origin + " -> " + destination + " (" + cost + ")\n";
    }

    protected int compareTo(BaseNode<T> o) {
        if (this.cost > o.cost) {
            return 1;
        } else if (this.cost < o.cost) {
            return -1;
        }
        return 0;
    }
}
