package PathFinding;

import Exceptions.DestinationNotReachable;
import MyCollections.Graph.Graph;
import MyCollections.HashTable.HashMap;
import MyCollections.Heap.MinHeap;

import java.util.ArrayList;

public abstract class PathFinding<T, R> {
    protected final Graph<T> nodeGraph;
    protected final ArrayList<T> traversedT;
    protected final MinHeap<PathFindNode<T>> toTraverseMinHeap;
    protected HashMap<T, PathFindNode<T>> toTraverseHashMap;
    protected final ArrayList<PathFindNode<T>> bestPath;

    public PathFinding(Graph<T> nodeGraph) {
        this.nodeGraph = nodeGraph;

        this.traversedT = new ArrayList<>();
        this.toTraverseMinHeap = (MinHeap<PathFindNode<T>>) new MinHeap<>(new PathFindNode<T>(null, null, 0).getClass());

        this.toTraverseHashMap = new HashMap<>();
        this.bestPath = new ArrayList<>();
    }

    public abstract R calculatePath() throws DestinationNotReachable;
}