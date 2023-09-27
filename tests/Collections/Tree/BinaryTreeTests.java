package Collections.Tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTests {
    @Test
    public void EmptyTree_AddingElements_WorksCorrectly() {
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
}