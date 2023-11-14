package PathFinding.Nodes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PathFindNodeTests {
    @Test
    public void NodesWithDifferentCost_CompareThem_ReturnsCorrectly() {
        PathFindNode<String> node1 = new PathFindNode<>("a", "a", 2);
        PathFindNode<String> node2 = new PathFindNode<>("a", "a", 5);
        assertEquals(-1, node1.compareTo(node2));

        PathFindNode<String> node3 = new PathFindNode<>("a", "a", 2);
        assertEquals(0, node1.compareTo(node3));

        PathFindNode<String> node4 = new PathFindNode<>("a", "a", 8);
        assertEquals(1, node4.compareTo(node2));
    }
}
