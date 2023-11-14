package PathFinding.Nodes;

// TODO: Separated this and KruskalConnection because I couldn't make them use the same comparable.
public class PathFindNode<T> extends BaseNode<T> implements Comparable<PathFindNode<T>> {

    public PathFindNode(T destination, T origin, double cost) {
        super(destination, origin, cost);
    }

    @Override
    public int compareTo(PathFindNode<T> o) {
        return super.compareTo(o);
    }
}