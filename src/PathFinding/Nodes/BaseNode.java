package PathFinding.Nodes;

public class BaseNode<T> {
    protected T origin;
    protected final T destination;
    protected double cost;

    public BaseNode(T origin, T destination, double cost) {
        this.origin = origin;
        this.destination = destination;
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