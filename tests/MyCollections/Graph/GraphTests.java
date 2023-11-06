package MyCollections.Graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTests {

    @Test
    public void EmptyGraph_AddingElements_WorksCorrectly() {
        Graph<String> graph = new Graph<>();
        graph.addNode("One");
        graph.addNode("Two");
        graph.addNode("Three");
        assertEquals(3, graph.getNodes().length);
        assertTrue(graph.contains("One"));
        assertTrue(graph.contains("Two"));
        assertTrue(graph.contains("Three"));
    }

    @Test
    public void EmptyGraphWithSomeElements_TryingToAddExistingElements_DoesNotChangeTheGraphAndReturnsNull() {
        Graph<String> graph = new Graph<>();
        graph.addNode("One");
        graph.addNode("Two");
        graph.addNode("Three");
        assertEquals(3, graph.getNodes().length);
        assertTrue(graph.contains("One"));
        assertTrue(graph.contains("Two"));
        assertTrue(graph.contains("Three"));

        // Actual test here:

        assertNull(graph.addNode("One"));
        assertNull(graph.addNode("Two"));
        assertNull(graph.addNode("Three"));
        assertEquals(3, graph.getNodes().length);
    }

    @Test
    public void GraphWithSomeElements_Contains_ReturnsCorrectly() {
        Graph<String> graph = new Graph<>();
        graph.addNode("One");
        GraphNode<String> newNode = new GraphNode<>("Four");
        graph.addNode(newNode);

        assertTrue(graph.contains("One"));
        assertTrue(graph.contains(newNode));
        assertFalse(graph.contains("Three"));
    }

    @Test
    public void GraphWithSomeElements_Get_ReturnsCorrectly() {
        Graph<String> graph = new Graph<>();
        graph.addNode("One");

        assertEquals(new GraphNode<>("One"), graph.getNode("One"));
    }

    @Test
    public void GraphWithSomeElements_ConnectingMutual_ConnectsBothNodesToEachOther() {
        Graph<String> graph = new Graph<>();
        graph.addNode("One");
        graph.addNode("Two");
        graph.addNode("Three");

        graph.connectMutual("One", "Two", 1, 2);
        graph.connectMutual("Two", "Three", 3, 2);

        assertEquals(3, graph.getNodes().length);

        GraphNode<String> one = graph.getNode("One");
        GraphNode<String> two = graph.getNode("Two");
        GraphNode<String> three = graph.getNode("Three");

        assertEquals(1, one.getConnections().length);
        assertTrue(one.hasConnectionTo("Two"));
        assertFalse(one.hasConnectionTo("Three"));
        assertFalse(one.hasConnectionTo("One"));

        assertEquals(2, two.getConnections().length);
        assertTrue(two.hasConnectionTo("One"));
        assertTrue(two.hasConnectionTo("Three"));
        assertFalse(two.hasConnectionTo("Two"));

        assertEquals(1, three.getConnections().length);
        assertTrue(three.hasConnectionTo("Two"));
        assertFalse(three.hasConnectionTo("Three"));
        assertFalse(three.hasConnectionTo("One"));
    }

    @Test
    public void GraphWithSomeElements_ConnectingOneWay_ConnectsOnlyTheFirstNodeToTheDestination() {
        Graph<String> graph = new Graph<>();
        graph.addNode("One");
        graph.addNode("Two");
        graph.addNode("Three");

        graph.connectOneWay("One", "Two", 1);
        graph.connectOneWay("Two", "Three", 3);

        assertEquals(3, graph.getNodes().length);

        GraphNode<String> one = graph.getNode("One");
        GraphNode<String> two = graph.getNode("Two");
        GraphNode<String> three = graph.getNode("Three");

        assertEquals(1, one.getConnections().length);
        assertTrue(one.hasConnectionTo("Two"));
        assertFalse(one.hasConnectionTo("Three"));
        assertFalse(one.hasConnectionTo("One"));

        assertEquals(1, two.getConnections().length);
        assertTrue(two.hasConnectionTo("Three"));
        assertFalse(two.hasConnectionTo("One"));
        assertFalse(two.hasConnectionTo("Two"));

        assertEquals(0, three.getConnections().length);
        assertFalse(three.hasConnectionTo("Two"));
        assertFalse(three.hasConnectionTo("Three"));
        assertFalse(three.hasConnectionTo("One"));
    }

    @Test
    public void GraphWithSomeElements_TraversingDepth_ReturnsCorrectOrder() {
        Graph<String> graph = new Graph<>();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
        graph.addNode("G");
        graph.addNode("X");
        graph.addNode("Y");
        graph.addNode("Z");

        // Some connection that is not connected to "A".
        graph.connectMutual("X", "Z",2,2);

        graph.connectMutual("A", "B", 0, 0);
        graph.connectMutual("B", "D", 0, 0);
        graph.connectMutual("B", "F", 0, 0);
        graph.connectMutual("F", "E", 0, 0);
        graph.connectMutual("A", "C", 0, 0);
        graph.connectMutual("C", "G", 0, 0);
        graph.connectMutual("A", "E", 0, 0);

        assertEquals("[A, B, D, F, E, C, G]", Arrays.toString(graph.traverseDepthFrom("A")));
        assertEquals("[X, Y, Z]", Arrays.toString(graph.traverseDepthFromExcluded("A")));

        assertEquals("[X, Z]", Arrays.toString(graph.traverseDepthFrom("X")));
        assertEquals("[A, B, C, D, E, F, G, Y]", Arrays.toString(graph.traverseDepthFromExcluded("X")));
        System.out.println(graph.toGraphViz());
    }

    @Test
    public void GraphWithSomeNodes_getWeight_ReturnsCorrect() {
        Graph<String> graph = new Graph<>();
        graph.addNode("A");
        graph.addNode("B");

        graph.connectMutual("A", "B", 1, 2);
        assertEquals(1, graph.getNodes()[0].getConnections()[0].getWeight());
        assertEquals(2, graph.getNodes()[1].getConnections()[0].getWeight());
    }

    @Test
    public void GraphWithManyNodes_ToGraphViz_ReturnsCorrectly() {
        Graph<String> graph = new Graph<>();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
        graph.addNode("G");
        graph.addNode("X");
        graph.addNode("Y");
        graph.addNode("Z");

        // Some connection that is not connected to "A".
        graph.connectMutual("X", "Z",2,2);

        graph.connectMutual("A", "B", 0, 0);
        graph.connectMutual("B", "D", 0, 0);
        graph.connectMutual("B", "F", 0, 0);
        graph.connectMutual("F", "E", 0, 0);
        graph.connectMutual("A", "C", 0, 0);
        graph.connectMutual("C", "G", 0, 0);
        graph.connectMutual("A", "E", 0, 0);

        assertEquals("A -> B [label=0]\n" +
                "A -> C [label=0]\n" +
                "A -> E [label=0]\n" +
                "B -> A [label=0]\n" +
                "B -> D [label=0]\n" +
                "B -> F [label=0]\n" +
                "C -> A [label=0]\n" +
                "C -> G [label=0]\n" +
                "D -> B [label=0]\n" +
                "E -> F [label=0]\n" +
                "E -> A [label=0]\n" +
                "F -> B [label=0]\n" +
                "F -> E [label=0]\n" +
                "G -> C [label=0]\n" +
                "X -> Z [label=2]\n" +
                "Y\n" +
                "Z -> X [label=2]\n", graph.toGraphViz());
    }

    @Test
    public void GraphWithSomeConnections_DisconnectSomeNodes_WorksProperly() {
        Graph<String> graph = new Graph<>();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.connectMutual("A", "B", 0, 0);
        graph.connectMutual("D", "B", 0, 0);
        graph.connectMutual("D", "C", 0, 0);
        graph.connectMutual("A", "C", 0, 0);

        assertEquals("A -> B [label=0]\n" +
                "A -> C [label=0]\n" +
                "B -> A [label=0]\n" +
                "B -> D [label=0]\n" +
                "C -> D [label=0]\n" +
                "C -> A [label=0]\n" +
                "D -> B [label=0]\n" +
                "D -> C [label=0]\n", graph.toGraphViz());

        graph.disconnectMutual("A", "B");
        System.out.println(graph.toGraphViz());
        assertEquals("A -> C [label=0]\n" +
                "B -> D [label=0]\n" +
                "C -> D [label=0]\n" +
                "C -> A [label=0]\n" +
                "D -> B [label=0]\n" +
                "D -> C [label=0]\n", graph.toGraphViz());
    }
}
