package PathFinding.Kruskal;

import PathFinding.Nodes.BaseNode;

public class KruskalConnection<T> extends BaseNode<T> implements Comparable<KruskalConnection<T>> {
    public KruskalConnection(T origin, T destination, double cost) {
        super(origin, destination, cost);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof KruskalConnection<?>)) return false;
        KruskalConnection<T> transferred = (KruskalConnection<T>) obj;

        if (!transferred.getOrigin().equals(getOrigin()) && !transferred.getOrigin().equals(getDestination()))
            return false;
        if (!transferred.getDestination().equals(getOrigin()) && !transferred.getDestination().equals(getDestination()))
            return false;
        return true;
    }

    @Override
    public int compareTo(KruskalConnection<T> o) {
        return super.compareTo(o);
    }
}