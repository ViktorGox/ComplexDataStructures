package PathFinding.Dijkstra;

import MyCollections.Graph.Graph;
import MyCollections.Graph.GraphConnection;
import PathFinding.Nodes.PathFindNode;
import PathFinding.DestinationPathFinding;

public class Dijkstra<T> extends DestinationPathFinding<T> {
    public Dijkstra(Graph<T> graph, T start, T destination) {
        super(graph, start, destination);
    }

    protected void calculatePathRecursive(PathFindNode<T> start) {
        traversedT.add(start.getDestination());
        toTraverseHashMap.put(start.getDestination(), start);
        if (start.getDestination().equals(destination)) {
            return;
        }

        for (GraphConnection<T> connection : nodeGraph.getNode(start.getDestination()).getConnections()) {
            PathFindNode<T> node = toTraverseHashMap.get(connection.getDestination().getData());
            double newCost = start.getCost() + connection.getWeight();
            if (node == null) {
                PathFindNode<T> newNode = new PathFindNode<>(start.getDestination(), connection.getDestination().getData(),
                        newCost);
                toTraverseHashMap.put(connection.getDestination().getData(), newNode);
                toTraverseMinHeap.push(newNode);
            } else {
                if(newCost < node.getCost()) {
                    node.setCost(newCost);
                    node.setOrigin(start.getDestination());
                }
            }
        }
        calculatePathRecursive(toTraverseMinHeap.pop());
    }
}