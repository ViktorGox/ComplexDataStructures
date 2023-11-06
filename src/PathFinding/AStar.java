package PathFinding;

import Exceptions.DestinationNotReachable;
import MyCollections.Graph.Graph;
import MyCollections.Graph.GraphConnection;
import MyCollections.HashTable.HashMap;
import MyCollections.Heap.MinHeap;

import java.util.ArrayList;
import java.util.function.BiFunction;

public class AStar<T extends Comparable<T>> {
    private final Graph<T> graph;
    private final MinHeap<AStarNode<T>> toTraverse;
    private final ArrayList<T> traversed;
    private final HashMap<T, AStarNode<T>> traversedHashMap;
    private final BiFunction<T, T, Double> distanceToTargetMethod;
    private final ArrayList<T> bestPath;
    private T start;
    private T destination;

    public AStar(Graph<T> graph, T start, T destination, BiFunction<T, T, Double> distanceToTargetMethod) {
        this.graph = graph;
        this.start = start;
        this.destination = destination;
        this.distanceToTargetMethod = distanceToTargetMethod;

        AStarNode<T> startNode = new AStarNode<>(start, destination, 0);

        this.traversed = new ArrayList<>();
        traversedHashMap = new HashMap<>();
        this.bestPath = new ArrayList<>();
        this.toTraverse = (MinHeap<AStarNode<T>>) new MinHeap<>(startNode.getClass());
    }

    public ArrayList<T> calculatePath() throws DestinationNotReachable {
        return calculatePath(start, destination);
    }

    public ArrayList<T> calculatePath(T start, T destination) throws DestinationNotReachable {
        traversed.clear();
        bestPath.clear();
        this.destination = destination;
        this.start = start;

        calculatePathRecursive(new AStarNode<>(start, start, 0));

        if (!traversed.contains(destination))
            throw new DestinationNotReachable("There was no path found to the destination " + start + " -> " + destination);
        return traverseOrigins(traversed);
    }

    private void calculatePathRecursive(AStarNode<T> start) {
        traversed.add(start.getDestination());
        traversedHashMap.put(start.getDestination(), start);
        if (start.getDestination().equals(destination)) {
            return;
        }

        for (GraphConnection<T> connection : graph.getNode(start.getDestination()).getConnections()) {
            if (traversed.contains(connection.getDestination().getData())) continue;

            Double currentConnectionToDestination = distanceToTargetMethod.apply(connection.getDestination().getData(), destination);
            Double currentConnectionToCurrent = distanceToTargetMethod.apply(connection.getDestination().getData(), this.start);
            double costF = currentConnectionToCurrent + currentConnectionToDestination;

            toTraverse.push(new AStarNode<>(start.getDestination(), connection.getDestination().getData(), costF));
        }
        calculatePathRecursive(toTraverse.pop());
    }

    public ArrayList<T> traverseOrigins(ArrayList<T> toTraverseInReverse) {
        AStarNode<T> start = traversedHashMap.get(toTraverseInReverse.get(toTraverseInReverse.size()-1));

        bestPath.add(destination);
        traverseOriginsRecursive(start);

        return bestPath;
    }

    public void traverseOriginsRecursive(AStarNode<T> start) {
        if (start.getDestination().equals(start.getOrigin())) return;
        bestPath.add(start.getOrigin());
        traverseOriginsRecursive(traversedHashMap.get(start.getOrigin()));
    }
}