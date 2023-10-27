package MyCollections.Graph;

import org.junit.jupiter.api.Test;

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

        graph.connectMutual("A", "B", 0, 0);
        graph.connectMutual("B", "D", 0, 0);
        graph.connectMutual("B", "F", 0, 0);
        graph.connectMutual("F", "E", 0, 0);
        graph.connectMutual("A", "C", 0, 0);
        graph.connectMutual("C", "G", 0, 0);

        System.out.println(graph.traverseDepth());
    }
}
