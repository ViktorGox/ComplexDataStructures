package PathFinding.Prim;

import Exceptions.DestinationNotReachable;
import MyCollections.Graph.Graph;
import MyCollections.Graph.GraphConnection;
import MyCollections.HashTable.HashMap;
import PathFinding.PathFinding;
import PathFinding.PathFindNode;

import java.util.ArrayList;

public class Prim<T> extends PathFinding<T> {

    public Prim(Graph<T> nodeGraph, T start) {
        super(nodeGraph, start, null);
    }

    public ArrayList<PathFindNode<T>> calculatePath(T start) throws DestinationNotReachable {
        traversedT.clear();
        toTraverseMinHeap.clear();
        toTraverseHashMap = new HashMap<>();
        bestPath.clear();

        this.start = start;

        calculatePathRecursive(new PathFindNode<>(start, start, 0));

        return traverseOrigins(traversedT);
    }

    @Override
    protected void calculatePathRecursive(PathFindNode<T> start) {
        traversedT.add(start.getDestination());
        toTraverseHashMap.put(start.getDestination(), start);
        if (toTraverseMinHeap.isEmpty() && !start.getDestination().equals(start.getOrigin())) {
            return;
        }

        for (GraphConnection<T> connection : nodeGraph.getNode(start.getDestination()).getConnections()) {
            PathFindNode<T> node = toTraverseHashMap.get(connection.getDestination().getData());
            double newCost = connection.getWeight();
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
