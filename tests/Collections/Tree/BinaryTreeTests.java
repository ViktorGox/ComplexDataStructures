package Collections.Tree;

import Collections.Tree.Binary.BinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTests {
    @Test
    public void EmptyTree_AddingElements_AddedCorrectly() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(30);
        binaryTree.add(28);
        binaryTree.add(32);
        binaryTree.add(31);
        binaryTree.add(33);
        binaryTree.add(34);
        binaryTree.add(29);
        binaryTree.add(27);
        assertEquals("27 28 29 30 31 32 33 34", binaryTree.getInOrder());
    }

    @Test
    public void EmptyTree_AddingAndDeletingElements_WorksCorrectly() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        //25,20,30,15,22,27,35,10,17,21,23,26,28,32,40
        binaryTree.add(25);
        binaryTree.add(20);
        binaryTree.add(30);
        binaryTree.add(15);
        binaryTree.add(22);
        binaryTree.add(27);
        binaryTree.add(35);
        binaryTree.add(10);
        binaryTree.add(17);
        binaryTree.add(21);
        binaryTree.add(23);
        binaryTree.add(26);
        binaryTree.add(28);
        binaryTree.add(32);
        binaryTree.add(40);
        assertEquals(25, binaryTree.remove(25));
        assertEquals(26, binaryTree.getRootData());
    }

    @Test
    public void TreeWithMultipleElements_GetThem_ReturnsCorrectDataOrNullIfNotExist() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        assertNull(binaryTree.get(30));

        binaryTree.add(30);
        binaryTree.add(28);
        binaryTree.add(32);
        binaryTree.add(31);
        binaryTree.add(33);
        binaryTree.add(34);
        binaryTree.add(29);
        binaryTree.add(27);
        assertEquals(30, binaryTree.get(30));
        assertEquals(28, binaryTree.get(28));
        assertEquals(32, binaryTree.get(32));
        assertEquals(31, binaryTree.get(31));
        assertEquals(33, binaryTree.get(33));
        assertEquals(34, binaryTree.get(34));
        assertEquals(29, binaryTree.get(29));
        assertEquals(27, binaryTree.get(27));

        assertNull(binaryTree.get(0));
        assertNull(binaryTree.get(100));
    }


    @Test
    public void TreeWithOneElement_RemovingTheRoot_MakesTreeEmpty() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(30);
        assertEquals(30, binaryTree.remove(30));
        assertEquals("", binaryTree.getInOrder());
    }

    @Test
    public void TreeWithTwoElementsLeftSide_RemovingTheRoot_MakesSecondElementRoot() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(30);
        binaryTree.add(28);
        assertEquals(30, binaryTree.remove(30));
        assertEquals("28", binaryTree.getInOrder());
        assertEquals(28, binaryTree.getRootData());
    }

    @Test
    public void TreeWithTwoElementsRightSide_RemovingTheRoot_MakesSecondElementRoot() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(30);
        binaryTree.add(32);
        assertEquals(30, binaryTree.remove(30));
        assertEquals("32", binaryTree.getInOrder());
        assertEquals(32, binaryTree.getRootData());
    }

    @Test
    public void TreeWithPerfectlyBalancedRoot_RemovingTheRoot_MakesTheBiggerElementTheRoot() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(30);
        binaryTree.add(28);
        binaryTree.add(32);
        assertEquals(30, binaryTree.remove(30));
        assertEquals("28 32", binaryTree.getInOrder());
        assertEquals(32, binaryTree.getRootData());
    }

    @Test
    public void TreeWithUnbalancedRootOnlyLeft_RemovingTheRoot_MakesSecondElementRoot() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(32);
        binaryTree.add(30);
        binaryTree.add(28);
        assertEquals(32, binaryTree.remove(32));
        assertEquals("28 30", binaryTree.getInOrder());
        assertEquals(30, binaryTree.getRootData());
    }

    @Test
    public void TreeWithUnbalancedRootOnlyRight_RemovingTheRoot_MakesSecondElementRoot() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(28);
        binaryTree.add(30);
        binaryTree.add(32);
        assertEquals(28, binaryTree.remove(28));
        assertEquals("30 32", binaryTree.getInOrder());
        assertEquals(30, binaryTree.getRootData());
    }

    @Test
    public void TreeWithUnbalancedRootToLeft_RemovingNonRootNonLeafNode_WorksCorrectly() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(30);
        binaryTree.add(28);
        binaryTree.add(26);
        assertEquals(28, binaryTree.remove(28));
        assertEquals("26 30", binaryTree.getInOrder());
        assertEquals(30, binaryTree.getRootData());
    }

    @Test
    public void TreeWithUnbalancedRootToRight_RemovingNonRootNonLeafNode_WorksCorrectly() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(30);
        binaryTree.add(32);
        binaryTree.add(34);
        assertEquals(32, binaryTree.remove(32));
        assertEquals("30 34", binaryTree.getInOrder());
        assertEquals(30, binaryTree.getRootData());
    }

    @Test
    public void TreeWithSomeElements_RemovingLeaf_WorksCorrectly() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(30);
        binaryTree.add(32);
        binaryTree.add(34);
        assertEquals(34, binaryTree.remove(34));
        assertEquals("30 32", binaryTree.getInOrder());
        assertEquals(30, binaryTree.getRootData());
    }

    @Test
    public void TreeWithOneElementToLeftAnManySubRightElements_RemoveRoot_WorksProperly() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(39);
        binaryTree.add(38);
        binaryTree.add(37);
        binaryTree.add(36);
        assertEquals(30, binaryTree.remove(30));
        assertEquals("36 37 38 39 40", binaryTree.getInOrder());
        assertEquals(40, binaryTree.getRootData());
    }

    @Test
    public void TreeWithOneElementToRightAnManySubLeftElements_RemoveRoot_WorksProperly() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(40);
        binaryTree.add(30);
        binaryTree.add(36);
        binaryTree.add(37);
        binaryTree.add(38);
        binaryTree.add(39);
        assertEquals(40, binaryTree.remove(40));
        assertEquals("30 36 37 38 39", binaryTree.getInOrder());
        assertEquals(30, binaryTree.getRootData());
    }

    @Test
    public void TreeWithOneElement_RemoveElementThatDoesNotExist_NothingHappens() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(40);
        assertNull(binaryTree.remove(23));
        assertEquals("40", binaryTree.getInOrder());
    }

    @Test
    public void TreeWithSomeElements_ContainsExistingNode_ReturnsTrue() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(40);
        binaryTree.add(30);
        binaryTree.add(36);
        binaryTree.add(37);
        binaryTree.add(38);
        binaryTree.add(39);
        assertTrue(binaryTree.contains(40));
    }

    @Test
    public void TreeWithSomeElements_ContainsNonExistingNode_ReturnsCorrectFalse() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(40);
        binaryTree.add(30);
        binaryTree.add(36);
        binaryTree.add(37);
        binaryTree.add(38);
        binaryTree.add(39);
        assertFalse(binaryTree.contains(45));
    }

    @Test
    public void TreeWithSomeElements_SizeMethod_ReturnsCorrectSize() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(40);
        binaryTree.add(30);
        binaryTree.add(36);
        binaryTree.add(37);
        binaryTree.add(38);
        binaryTree.add(39);
        assertEquals(6, binaryTree.size());
    }

    @Test
    public void TreeWithZeroElements_SizeMethod_ReturnsZero() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        assertEquals(0, binaryTree.size());
    }
}