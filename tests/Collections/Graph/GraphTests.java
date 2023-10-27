package Collections.Graph;

import org.junit.jupiter.api.Test;

public class GraphTests {

    @Test
    public void Test() {
        Graph<Integer> graph = new Graph<>();
        graph.addNode(1);
        graph.addNode(0);
        graph.connect(1,0,2);
        System.out.println(graph.toGraphViz());
    }
}
