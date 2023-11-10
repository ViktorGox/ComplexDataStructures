package PathFinding;

import Exceptions.DestinationNotReachable;
import MyCollections.Graph.Graph;
import MyCollections.HashTable.HashMap;

import java.util.ArrayList;

public abstract class DestinationPathFinding<T> extends PathFinding<T, ArrayList<PathFindNode<T>>> {
    protected T start;
    protected T destination;

    public DestinationPathFinding(Graph<T> nodeGraph, T start, T destination) {
        super(nodeGraph);
        this.start = start;
        this.destination = destination;
    }

    protected ArrayList<PathFindNode<T>> getResult(ArrayList<T> toTraverse) {
        return traverseOrigins(toTraverse);
    }

    @Override
    public ArrayList<PathFindNode<T>> calculatePath() throws DestinationNotReachable {
        return calculatePath(this.start, this.destination);
    }

    public ArrayList<PathFindNode<T>> calculatePath(T start, T destination) throws DestinationNotReachable {
        traversedT.clear();
        toTraverseMinHeap.clear();
        toTraverseHashMap = new HashMap<>();
        bestPath.clear();

        this.destination = destination;
        this.start = start;

        calculatePathRecursive(new PathFindNode<>(start, start, 0));

        if (!traversedT.contains(destination))
            throw new DestinationNotReachable("There was no path found to the destination " + start + " -> " + destination);
        return getResult(traversedT);
    }

    protected abstract void calculatePathRecursive(PathFindNode<T> start);

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
