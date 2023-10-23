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
        assertEquals(5,tree.getRootData());
        assertEquals(3,tree.size());
    }

    @Test
    public void TreeWith3Elements_PerformLL_PerformsCorrectly() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(10);
        tree.add(15);
        tree.add(20);
        assertEquals(15,tree.getRootData());
        assertEquals(3,tree.size());
    }

    @Test
    public void TreeWith3Elements_PerformRL_PerformsCorrectly() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(10);
        tree.add(5);
        tree.add(8);
        assertEquals(8,tree.getRootData());
        assertEquals(3,tree.size());
    }

    @Test
    public void TreeWith3Elements_PerformLR_PerformsCorrectly() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(10);
        tree.add(15);
        tree.add(12);
        assertEquals(12,tree.getRootData());
        assertEquals(3,tree.size());
    }

    @Test
    public void TreeWith3Elements_AddingDuplicate_NothingHappens() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(10);
        tree.add(15);
        tree.add(12);
        tree.add(12);
        assertEquals(12,tree.getRootData());
        assertEquals(3,tree.size());
    }
}