package PathFinding.Kruskal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KruskalConnectionTests {
    @Test
    public void NodesWithDifferentCost_CompareThem_ReturnsCorrectly() {
        KruskalConnection<String> node1 = new KruskalConnection<>("a", "a", 2);
        KruskalConnection<String> node2 = new KruskalConnection<>("a", "a", 5);
        assertEquals(-1, node1.compareTo(node2));

        KruskalConnection<String> node3 = new KruskalConnection<>("a", "a", 2);
        assertEquals(0, node1.compareTo(node3));

        KruskalConnection<String> node4 = new KruskalConnection<>("a", "a", 8);
        assertEquals(1, node4.compareTo(node2));
    }

    @Test
    public void MultipleNodes_CheckEquals_WorksCorrectly() {
        KruskalConnection<String> node1 = new KruskalConnection<>("a", "b", 2);
        KruskalConnection<String> node2 = new KruskalConnection<>("b", "a", 2);
        KruskalConnection<String> node3 = new KruskalConnection<>("c", "a", 2);
        KruskalConnection<String> node4 = new KruskalConnection<>("a", "c", 2);

        assertEquals(node1, node2);
        assertNotEquals(node1,node3);
        assertNotEquals(node2,node4);
    }
}
