package PathFinding;

import Exceptions.DestinationNotReachable;
import MyCollections.Graph.Graph;
import MyCollections.HashTable.HashMap;
import MyCollections.Heap.MinHeap;

import java.util.ArrayList;

public abstract class PathFinding<T> {
    protected final Graph<T> nodeGraph;
    protected final ArrayList<T> traversedT;
    protected final MinHeap<PathFindNode<T>> toTraverseMinHeap;
    protected HashMap<T, PathFindNode<T>> toTraverseHashMap;
    protected final ArrayList<PathFindNode<T>> bestPath;
    protected T start;
    protected T destination;

    public PathFinding(Graph<T> nodeGraph, T start, T destination) {
        this.nodeGraph = nodeGraph;
        this.start = start;
        this.destination = destination;

        this.traversedT = new ArrayList<>();

        PathFindNode<T> startNode = new PathFindNode<>(start, destination, 0);
        this.toTraverseMinHeap = (MinHeap<PathFindNode<T>>) new MinHeap<>(startNode.getClass());

        this.toTraverseHashMap = new HashMap<>();
        this.bestPath = new ArrayList<>();
    }

    public ArrayList<PathFindNode<T>> calculatePath() throws DestinationNotReachable {
        return calculatePath(start, destination);
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
    protected abstract ArrayList<PathFindNode<T>> getResult(ArrayList<T> toTraverse);
}