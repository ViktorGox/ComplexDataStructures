package Collections.Tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AVLTreeTests {

    @Test
    public void TreeWith3Elements_PerformRR_PerformsCorrectly() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(10);
        tree.add(5);
        tree.add(2);
        assertEquals(5, tree.getRootData());
        assertEquals(3, tree.size());
    }

    @Test
    public void TreeWith3Elements_PerformLL_PerformsCorrectly() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(10);
        tree.add(15);
        tree.add(20);
        assertEquals(15, tree.getRootData());
        assertEquals(3, tree.size());
    }

    @Test
    public void TreeWith3Elements_PerformRL_PerformsCorrectly() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(10);
        tree.add(5);
        tree.add(8);
        assertEquals(8, tree.getRootData());
        assertEquals(3, tree.size());
    }

    @Test
    public void TreeWith3Elements_PerformLR_PerformsCorrectly() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(10);
        tree.add(15);
        tree.add(12);
        assertEquals(12, tree.getRootData());
        assertEquals(3, tree.size());
    }

    @Test
    public void TreeWith3Elements_AddingDuplicate_NothingHappens() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(10);
        tree.add(15);
        tree.add(12);
        tree.add(12);
        assertEquals(12, tree.getRootData());
        assertEquals(3, tree.size());
    }

    @Test
    public void TreeWithManyElements_RemovingRoot_WorksCorrectly() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(10);
        tree.add(15);
        tree.add(20);
        tree.add(21);
        tree.add(22);
        tree.add(23);
        tree.add(24);
        assertEquals(7, tree.size());
        assertEquals(21, tree.getRootData());
        assertEquals(21, tree.remove(21));
        assertEquals(6, tree.size());
        assertEquals(22, tree.getRootData());
    }

    @Test
    public void TreeWithManyElements_RemovingLeaf_WorksCorrectly() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(10);
        tree.add(15);
        tree.add(20);
        tree.add(21);
        tree.add(22);
        tree.add(23);
        tree.add(24);
        assertEquals(7, tree.size());
        assertEquals(21, tree.getRootData());
        assertEquals(10, tree.remove(10));
        assertEquals(6, tree.size());
        assertEquals(21, tree.getRootData());
    }

    @Test
    public void TreeWithManyElements_RemovingMiddleElementWithRightElementPresent_WorksCorrectly() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(10);
        tree.add(15);
        tree.add(20);
        tree.add(21);
        tree.add(22);
        tree.add(23);
        tree.add(24);
        assertEquals(7, tree.size());
        assertEquals(21, tree.getRootData());
        assertEquals(15, tree.remove(15));
        assertEquals(6, tree.size());
        assertEquals(21, tree.getRootData());
    }

    @Test
    public void TreeWithManyElements_RemovingMiddleElementWithLeftOnlyElementPresent_WorksCorrectly() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(10);
        tree.add(15);
        tree.add(20);
        tree.add(21);
        tree.add(22);
        tree.add(23);
        tree.add(24);
        tree.add(8);
        assertEquals(8, tree.size());
        assertEquals(21, tree.getRootData());
        assertEquals(10, tree.remove(10));
        assertEquals(7, tree.size());
        assertEquals(21, tree.getRootData());
    }

    @Test
    public void TreeWithSomeElements_RemoveElementThatDoesntExist_NothingHappens() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(10);
        tree.add(15);
        tree.add(20);
        assertEquals(3, tree.size());
        assertEquals(15, tree.getRootData());
        tree.remove(215);
        assertNull(tree.remove(215));
        assertEquals(15, tree.getRootData());
    }

    @Test
    public void TreeWithSomeElements_ContainsExistingElement_ReturnsTrue() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(10);
        tree.add(15);
        tree.add(20);
        tree.add(21);
        tree.add(22);
        tree.add(23);
        tree.add(24);
        tree.add(8);
        assertTrue(tree.contains(22));
    }
}