package PathFinding.Dijkstra;

import Exceptions.DestinationNotReachable;
import MyCollections.Graph.Graph;
import PathFinding.Nodes.PathFindNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DijkstraTests {
    @Test
    public void Dijkstra_FindPathWithNodesFromPresentation_WorksCorrectly() {
        try {
            Dijkstra<String> dijkstra = new Dijkstra<>(getPresentationGraph(), "a", "f");
            ArrayList<PathFindNode<String>> result = dijkstra.calculatePath();
            System.out.println(result);
            assertEquals("g", result.get(0).getOrigin());
            assertEquals(10, result.get(0).getCost());

            assertEquals("d", result.get(1).getOrigin());
            assertEquals(5, result.get(1).getCost());

            assertEquals("b", result.get(2).getOrigin());
            assertEquals(4, result.get(2).getCost());

            assertEquals("a", result.get(3).getOrigin());
            assertEquals(1, result.get(3).getCost());

        } catch (DestinationNotReachable e) {
            throw new RuntimeException(e);
        }
    }

    private Graph<String> getPresentationGraph() {
        Graph<String> presentationGraph = new Graph<>();
        presentationGraph.addNode("a");
        presentationGraph.addNode("b");
        presentationGraph.addNode("c");
        presentationGraph.addNode("d");
        presentationGraph.addNode("e");
        presentationGraph.addNode("f");
        presentationGraph.addNode("g");

        presentationGraph.connectMutual("a", "b", 1, 1);
        presentationGraph.connectMutual("a", "c", 4, 4);

        presentationGraph.connectMutual("b", "e", 10, 10);
        presentationGraph.connectMutual("b", "c", 2, 2);
        presentationGraph.connectMutual("b", "d", 3, 3);

        presentationGraph.connectMutual("c", "g", 3, 3);
        presentationGraph.connectMutual("d", "g", 1, 1);
        presentationGraph.connectMutual("g", "e", 2, 2);

        presentationGraph.connectMutual("d", "c", 6, 6);
        presentationGraph.connectMutual("d", "e", 5, 5);

        presentationGraph.connectMutual("g", "f", 5, 5);
        presentationGraph.connectMutual("e", "f", 7, 7);
        return presentationGraph;
    }
}