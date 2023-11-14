package PathFinding.Nodes;

// TODO: Separated this and KruskalConnection because I couldn't make them use the same comparable.
public class PathFindNode<T> extends BaseNode<T> implements Comparable<PathFindNode<T>> {

    public PathFindNode(T origin, T destination, double cost) {
        super(origin, destination, cost);
    }

    @Override
    public int compareTo(PathFindNode<T> o) {
        return super.compareTo(o);
    }
}