package PathFinding.Kruskal;

import MyCollections.Graph.Graph;
import MyCollections.Graph.GraphConnection;
import MyCollections.Graph.GraphNode;
import MyCollections.Heap.MinHeap;

import java.util.ArrayList;
import java.util.function.Function;

public class Kruskal<T> {
    protected final Graph<T> nodeGraph;
    private final Function<T, Double> getLatitude;
    private final Function<T, Double> getLongitude;
    protected final MinHeap<KruskalConnection<T>> toTraverseMinHeap;
    private final ArrayList<KruskalConnection<T>> knownConnections;
    private T point1;
    private T point2;
    private Graph<T> filteredGraph;

    public Kruskal(Graph<T> nodeGraph, Function<T, Double> getLatitude, Function<T, Double> getLongitude
            , T point1, T point2) {
        this.nodeGraph = nodeGraph;
        this.getLatitude = getLatitude;
        this.getLongitude = getLongitude;
        this.point1 = point1;
        this.point2 = point2;
        this.filteredGraph = new Graph<>();
        this.toTraverseMinHeap = (MinHeap<KruskalConnection<T>>) new MinHeap<>(new KruskalConnection<T>(null, null, 0).getClass());
        this.knownConnections = new ArrayList<>();
    }

    private Graph<T> filterNodes() {
        double[] xBoundaries = getCorrectBoundaries(point1, point2, getLongitude);
        double xLow = xBoundaries[0];
        double xHigh = xBoundaries[1];

        double[] yBoundaries = getCorrectBoundaries(point2, point1, getLatitude);
        double yLow = yBoundaries[0];
        double yHigh = yBoundaries[1];

        for (GraphNode<T> node : nodeGraph.getNodes()) {
            T current = node.getData();

            double xCurrent = getLongitude.apply(current);
            double yCurrent = getLatitude.apply(current);

            if (xCurrent < xLow) continue;
            if (xCurrent > xHigh) continue;
            if (yCurrent < yLow) continue;
            if (yCurrent > yHigh) continue;

            filteredGraph.addNode(node.getData());
        }


        for (GraphNode<T> node : filteredGraph.getNodes()) {
            exploreNodes(node.getData());
        }

        moveKnownConnectionsToMinHeap();

        return filteredGraph;
    }

    /**
     * Takes the values of the two given edges of one axis, and sorts them lower/higher.
     * So when checking if a node is in the range, we know which is the higher and lower boundary.
     *
     * @return point values sorted 0 = low, 1 = high.
     */
    private double[] getCorrectBoundaries(T point1, T point2, Function<T, Double> function) {
        double axisOne = function.apply(point1);
        double axisTwo = function.apply(point2);
        double[] result = new double[2];
        if (axisOne < axisTwo) {
            result[0] = axisOne;
            result[1] = axisTwo;
        } else {
            result[0] = axisTwo;
            result[1] = axisOne;
        }
        return result;
    }

    private void exploreNodes(T data) {
        GraphNode<T> realNode = nodeGraph.getNode(data);

        for (GraphConnection<T> connection : realNode.getConnections()) {
            if (!filteredGraph.connectOneWay(data, connection.getDestination().getData(), connection.getWeight()))
                continue;
            addIfNotExist(new KruskalConnection<>(data, connection.getDestination().getData(), connection.getWeight()));
        }
    }

    public Graph<T> calculatePath() {
        Graph<T> result = new Graph<>();
        Graph<T> filteredGraph = filterNodes();

        result.copyNodeData(filteredGraph);


        while (!toTraverseMinHeap.isEmpty()) {
            KruskalConnection<T> current = toTraverseMinHeap.pop();

            GraphNode<T> destination = new GraphNode<>(current.getDestination());
            GraphNode<T>[] traverseResult = result.traverseDepthFrom(current.getOrigin());

            boolean loop = false;
            for (GraphNode<T> tGraphNode : traverseResult) {
                if (tGraphNode.equals(destination)) {
                    loop = true;
                    break;
                }
            }
            if (loop) continue;
            result.connectMutual(current.getDestination(), current.getOrigin(), current.getCost(), current.getCost());
        }
        return result;
    }

    private void addIfNotExist(KruskalConnection<T> connection) {
        if (knownConnections.contains(connection)) return;
        knownConnections.add(connection);
    }

    private void moveKnownConnectionsToMinHeap() {
        for (KruskalConnection<T> knownConnection : knownConnections) {
            toTraverseMinHeap.push(knownConnection);
        }
    }
}
