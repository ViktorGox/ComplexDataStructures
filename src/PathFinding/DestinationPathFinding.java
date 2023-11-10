package PathFinding;

import MyCollections.Graph.Graph;

import java.util.ArrayList;

public abstract class DestinationPathFinding<T> extends PathFinding<T>{
    public DestinationPathFinding(Graph<T> nodeGraph, T start, T destination) {
        super(nodeGraph, start, destination);
    }

    @Override
    protected ArrayList<PathFindNode<T>> getResult(ArrayList<T> toTraverse) {
        return traverseOrigins(toTraverse);
    }

    public ArrayList<PathFindNode<T>> traverseOrigins(ArrayList<T> toTraverseInReverse) {
        PathFindNode<T> start = toTraverseHashMap.get(toTraverseInReverse.get(toTraverseInReverse.size() - 1));

        traverseOriginsRecursive(start);

        return bestPath;
    }

    public void traverseOriginsRecursive(PathFindNode<T> start) {
        if (start.getDestination().equals(start.getOrigin())) return;
        bestPath.add(start);
        traverseOriginsRecursive(toTraverseHashMap.get(start.getOrigin()));
    }
}
