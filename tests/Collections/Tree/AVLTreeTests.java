package Collections.Tree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AVLTreeTests {
    @Test
    public void EmptyTree_AddingElement_AddsIt() {//10,20,30,40,50,11,70,21,22
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(10);
        tree.add(20);
        tree.add(30);
//        tree.add(40);
//        tree.add(50);
//        tree.add(11);
//        tree.add(70);
//        tree.add(21);
//        tree.add(22);
        System.out.println(tree.getNode(10));
    }
}