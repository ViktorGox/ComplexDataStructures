package PathFinding.Prim;

import MyCollections.Graph.Graph;
import MyCollections.Graph.GraphConnection;
import MyCollections.HashTable.HashMap;
import PathFinding.PathFinding;
import PathFinding.PathFindNode;

import java.util.ArrayList;

public class Prim<T> extends PathFinding<T, Graph<T>> {
    // Result gprah doesn't work fully.
    private T start;
    public Prim(Graph<T> nodeGraph, T start) {
        super(nodeGraph);
        this.start = start;
    }

    @Override
    public Graph<T> calculatePath() {
        return calculatePath(start);
    }
    
    public Graph<T> calculatePath(T start) {
        traversedT.clear();
        toTraverseMinHeap.clear();
        toTraverseHashMap = new HashMap<>();
        bestPath.clear();

        this.start = start;

        calculatePathRecursive(new PathFindNode<>(start, start, 0));

        return getResult(traversedT);
    }

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

    protected Graph<T> getResult(ArrayList<T> toTraverse) {
        Graph<T> resultGraph = new Graph<>();
        if(toTraverse.size() == 0) return resultGraph;

        // I add the first node here, since the first element of toTraverse always points to itself.
        resultGraph.addNode(toTraverseHashMap.get(toTraverse.get(0)).getOrigin());

        for (int i = 1; i < toTraverse.size(); i++) {
            PathFindNode<T> node = toTraverseHashMap.get(toTraverse.get(i));
            resultGraph.addNode(node.getDestination());
            resultGraph.connectMutual(node.getDestination(), node.getOrigin(), node.getCost(), node.getCost());
        }

        return resultGraph;
    }
}
