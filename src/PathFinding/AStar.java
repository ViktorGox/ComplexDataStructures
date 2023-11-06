package PathFinding;

import Exceptions.DestinationNotReachable;
import MyCollections.Graph.Graph;
import MyCollections.Graph.GraphConnection;
import MyCollections.Heap.MinHeap;

import java.util.ArrayList;
import java.util.function.BiFunction;

public class AStar<T extends Comparable<T>> {
    private final Graph<T> graph;
    private final ArrayList<T> traversedSoFar;
    private final MinHeap<AStarNode<T>> toTraverse;
    private final ArrayList<T> path;
    private final BiFunction<T, T, Double> distanceToTargetMethod;
    private T start;
    private T destination;

    public AStar(Graph<T> graph,T start, T destination, BiFunction<T, T, Double> distanceToTargetMethod) {
        this.graph = graph;
        this.start = start;
        this.destination = destination;
        this.distanceToTargetMethod = distanceToTargetMethod;

        AStarNode<T> startNode = new AStarNode<>(start,destination,0);

        this.path = new ArrayList<>();
        this.toTraverse = (MinHeap<AStarNode<T>>) new MinHeap<>(startNode.getClass());
        traversedSoFar = new ArrayList<>();
    }

    public ArrayList<T> calculatePath() throws DestinationNotReachable {
        return calculatePath(start,destination);
    }

    public ArrayList<T> calculatePath(T start, T destination) throws DestinationNotReachable {
        traversedSoFar.clear();
        this.destination = destination;
        this.start = start;
        path.add(calculatePathRecursive(start));
        if (!path.contains(destination))
            throw new DestinationNotReachable("There was no path found to the destination " + start + " -> " + destination);
        return path;
    }

    private T calculatePathRecursive(T start) {
        if (start.equals(destination)) {
            return start;
        }
        traversedSoFar.add(start);

        T current = start;

        double bestOption = 999999.0;

        for (GraphConnection<T> connection : graph.getNode(start).getConnections()) {
            if (traversedSoFar.contains(connection.getDestination().getData())) continue;

            Double currentConnectionToDestination = distanceToTargetMethod.apply(connection.getDestination().getData(), destination);
            Double currentConnectionToCurrent = distanceToTargetMethod.apply(connection.getDestination().getData(), start);
            double costF = currentConnectionToCurrent + currentConnectionToDestination;
            if (costF < bestOption) {
                bestOption = costF;
                current = connection.getDestination().getData();
            }
        }


        path.add(calculatePathRecursive(current));
        return start;
    }
}