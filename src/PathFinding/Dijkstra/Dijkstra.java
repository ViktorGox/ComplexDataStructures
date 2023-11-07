package PathFinding.Dijkstra;

import Exceptions.DestinationNotReachable;
import MyCollections.Graph.Graph;
import MyCollections.Graph.GraphConnection;
import MyCollections.HashTable.HashMap;
import MyCollections.Heap.MinHeap;
import PathFinding.PathFindNode;

import java.util.ArrayList;

public class Dijkstra<T> {
    private final Graph<T> graph;
    private final HashMap<T, PathFindNode<T>> foundNodes;
    private final MinHeap<PathFindNode<T>> toTraverseNodes;
    private final ArrayList<T> traversed;
    private T start;
    private T destination;
    private final ArrayList<T> bestPath;

    public Dijkstra(Graph<T> graph, T start, T destination) {
        this.graph = graph;
        this.start = start;
        this.destination = destination;

        this.foundNodes = new HashMap<>();
        this.traversed = new ArrayList<>();
        this.bestPath = new ArrayList<>();

        PathFindNode<T> startNode = new PathFindNode<>(start, destination, 0);
        this.toTraverseNodes = (MinHeap<PathFindNode<T>>) new MinHeap<>(startNode.getClass());
    }

    public DijkstraAnswer calculatePath() throws DestinationNotReachable {
        return calculatePath(start, destination);
    }

    public DijkstraAnswer calculatePath(T start, T destination) throws DestinationNotReachable {
        traversed.clear();
        this.destination = destination;
        this.start = start;

        calculatePathRecursive(new PathFindNode<>(start, start, 0));

        if (!traversed.contains(destination))
            throw new DestinationNotReachable("There was no path found to the destination " + start + " -> " + destination);
        return traverseOrigins(traversed);
    }

    private void calculatePathRecursive(PathFindNode<T> start) {
        traversed.add(start.getDestination());
        foundNodes.put(start.getDestination(), start);
        if (start.getDestination().equals(destination)) {
            return;
        }

        for (GraphConnection<T> connection : graph.getNode(start.getDestination()).getConnections()) {
            PathFindNode<T> node = foundNodes.get(connection.getDestination().getData());
            double newCost = start.getCost() + connection.getWeight();
            if (node == null) {
                PathFindNode<T> newNode = new PathFindNode<>(start.getDestination(), connection.getDestination().getData(),
                        newCost);
                foundNodes.put(connection.getDestination().getData(), newNode);
                toTraverseNodes.push(newNode);
            } else {
                if(newCost < node.getCost()) {
                    node.setCost(newCost);
                    node.setOrigin(start.getDestination());
                }
            }
        }
        calculatePathRecursive(toTraverseNodes.pop());
    }

    public DijkstraAnswer traverseOrigins(ArrayList<T> toTraverseInReverse) {
        PathFindNode<T> start = foundNodes.get(toTraverseInReverse.get(toTraverseInReverse.size()-1));

        bestPath.add(destination);
        traverseOriginsRecursive(start);

        return new DijkstraAnswer(bestPath, start.getCost());
    }

    public void traverseOriginsRecursive(PathFindNode<T> start) {
        if (start.getDestination().equals(start.getOrigin())) return;
        bestPath.add(start.getOrigin());
        traverseOriginsRecursive(foundNodes.get(start.getOrigin()));
    }

    public class DijkstraAnswer {
        private ArrayList<T> bestPath;
        private double cost;

        public DijkstraAnswer(ArrayList<T> bestPath, double cost) {
            this.bestPath = bestPath;
            this.cost = cost;
        }

        public ArrayList<T> getBestPath() {
            return bestPath;
        }

        public double getCost() {
            return cost;
        }

        @Override
        public String toString() {
            return bestPath + " Cost: " + cost;
        }
    }
}