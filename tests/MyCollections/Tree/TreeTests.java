package MyCollections.Tree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TreeTests {

    @Test
    public void TreeAsAVLWithSomeElements_GetInOrder_ReturnsCorrect() {
        Tree<Integer> tree = new AVLTree<>();
        tree.add(54);
        tree.add(27);
        tree.add(89);
        tree.add(13);
        tree.add(44);
        tree.add(71);
        tree.add(92);
        tree.add(1);
        tree.add(37);
        tree.add(64);

        assertEquals("1 13 27 37 44 54 64 71 89 92", tree.getInOrder());
    }

    @Test
    public void TreeAsAVLWithSomeElements_GetPreOrder_ReturnsCorrect() {
        Tree<Integer> tree = new AVLTree<>();
        tree.add(54);
        tree.add(27);
        tree.add(89);
        tree.add(13);
        tree.add(44);
        tree.add(71);
        tree.add(92);
        tree.add(1);
        tree.add(37);
        tree.add(64);

        assertEquals("54 27 13 1 44 37 89 71 64 92", tree.getPreorder());
    }

    @Test
    public void TreeAsAVLWithSomeElements_GetPostOrder_ReturnsCorrect() {
        Tree<Integer> tree = new AVLTree<>();
        tree.add(54);
        tree.add(27);
        tree.add(89);
        tree.add(13);
        tree.add(44);
        tree.add(71);
        tree.add(92);
        tree.add(1);
        tree.add(37);
        tree.add(64);

        assertEquals("1 13 37 44 27 64 71 92 89 54", tree.getPostorder());
    }

    @Test
    public void TreeWithSomeNodes_ToGraphViz_returnsCorrectly() {
        Tree<Integer> tree = new AVLTree<>();
        tree.add(54);
        tree.add(27);
        tree.add(89);
        tree.add(13);
        tree.add(44);
        tree.add(71);
        tree.add(92);
        tree.add(1);
        tree.add(37);
        tree.add(64);

        assertEquals("54 -> 27\n" +
                "54 -> 89\n" +
                "27 -> 13\n" +
                "27 -> 44\n" +
                "13 -> 1\n" +
                "44 -> 37\n" +
                "89 -> 71\n" +
                "89 -> 92\n" +
                "71 -> 64\n", tree.graphViz());
    }
}
