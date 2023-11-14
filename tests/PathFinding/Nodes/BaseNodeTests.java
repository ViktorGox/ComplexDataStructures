package PathFinding.Nodes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseNodeTests {
    @Test
    public void BaseNode_Getters_WorkCorrectly() {
        BaseNode<String> node1 = new BaseNode<>("a", "b", 2);
        assertEquals("a", node1.getDestination());
        assertEquals("b", node1.getOrigin());
        assertEquals(2, node1.getCost());
    }

    @Test
    public void BaseNode_Setters_WorkCorrectly() {
        BaseNode<String> node1 = new BaseNode<>("a", "b", 2);
        node1.setOrigin("z");
        assertEquals("z", node1.getOrigin());
        node1.setCost(0);
        assertEquals(0, node1.getCost());
    }


    @Test
    public void NodesWithDifferentCost_CompareThem_ReturnsCorrectly() {
        BaseNode<String> node1 = new BaseNode<>("a", "a", 2);
        BaseNode<String> node2 = new BaseNode<>("a", "a", 5);
        assertEquals(-1, node1.compareTo(node2));

        BaseNode<String> node3 = new BaseNode<>("a", "a", 2);
        assertEquals(0, node1.compareTo(node3));

        BaseNode<String> node4 = new BaseNode<>("a", "a", 8);
        assertEquals(1, node4.compareTo(node2));
    }
}