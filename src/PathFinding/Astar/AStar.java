package PathFinding.Astar;

import MyCollections.Graph.Graph;
import MyCollections.Graph.GraphConnection;
import PathFinding.Nodes.PathFindNode;
import PathFinding.DestinationPathFinding;

import java.util.function.BiFunction;

public class AStar<T extends Comparable<T>> extends DestinationPathFinding<T> {
    private final BiFunction<T, T, Double> distanceToTargetMethod;

    public AStar(Graph<T> graph, T start, T destination, BiFunction<T, T, Double> distanceToTargetMethod) {
        super(graph, start, destination);
        this.distanceToTargetMethod = distanceToTargetMethod;
    }

    protected void calculatePathRecursive(PathFindNode<T> start) {
        if(start == null) {
            return;
        }
        traversedT.add(start.getDestination());
        toTraverseHashMap.put(start.getDestination(), start);
        if (start.getDestination().equals(destination)) {
            return;
        }

        for (GraphConnection<T> connection : nodeGraph.getNode(start.getDestination()).getConnections()) {
            if (traversedT.contains(connection.getDestination().getData())) continue;

            Double currentConnectionToDestination = distanceToTargetMethod.apply(connection.getDestination().getData(), destination);
            Double currentConnectionToCurrent = distanceToTargetMethod.apply(connection.getDestination().getData(), this.start);
            double costF = currentConnectionToCurrent + currentConnectionToDestination;

            toTraverseMinHeap.push(new PathFindNode<>(start.getDestination(), connection.getDestination().getData(), costF));
        }
        calculatePathRecursive(toTraverseMinHeap.pop());
    }
}