package PathFinding.Prim;

import Exceptions.DestinationNotReachable;
import MyCollections.Graph.Graph;
import org.junit.jupiter.api.Test;

public class PrimTests {
    @Test
    public void someTestingMethod() {
        try {
            Prim<String> prim = new Prim<>(getPresentationGraph(), "a");
            System.out.println(prim.calculatePath());
        } catch (DestinationNotReachable e) {
            throw new RuntimeException(e);
        }
    }

    private Graph<String> getPresentationGraph() {
        Graph<String> presentationGraph = new Graph<>();
        presentationGraph.addNode("a");
        presentationGraph.addNode("b");
        presentationGraph.addNode("c");
        presentationGraph.addNode("d");
        presentationGraph.addNode("e");
        presentationGraph.addNode("f");
        presentationGraph.addNode("g");
        presentationGraph.addNode("h");
        presentationGraph.addNode("i");

        presentationGraph.connectMutual("a","b",4,4);
        presentationGraph.connectMutual("b","c",8,8);

        presentationGraph.connectMutual("c","d",7,7);
        presentationGraph.connectMutual("d","e",9,9);
        presentationGraph.connectMutual("e","f",10,10);

        presentationGraph.connectMutual("f","g",2,2);
        presentationGraph.connectMutual("g","h",1,1);
        presentationGraph.connectMutual("h","a",8,8);

        presentationGraph.connectMutual("h","i",7,7);
        presentationGraph.connectMutual("i","g",6,6);

        presentationGraph.connectMutual("i","c",2,2);
        presentationGraph.connectMutual("c","f",4,4);

        presentationGraph.connectMutual("h","b",11,11);
        presentationGraph.connectMutual("d","f",14,14);

        return presentationGraph;
    }
}
