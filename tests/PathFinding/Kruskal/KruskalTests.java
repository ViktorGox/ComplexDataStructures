package PathFinding.Kruskal;

import MyCollections.Graph.Graph;
import PathFinding.DummyStations;
import Stations.Station;
import org.junit.jupiter.api.Test;

public class KruskalTests {

    @Test
    public void GetLatTest() {
        Kruskal<String> kruskal = new Kruskal<>(DummyStations.getDummyStationGraphForKruskal(), Station::getGeoLat, Station::getGeoLng, "K", "L");
        System.out.println(kruskal.calculatePath().toGraphViz());
    }

    /**
     * The graph has 1 change from the presentation. The connection from A to H is 9, instead of 8.
     * If I set it to 8, then my graph chooses the connection a->h, which is still correct, but
     * causes it to be different from the solution of the presentation.
     */
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
        presentationGraph.connectMutual("h","a",9,9);

        presentationGraph.connectMutual("h","i",7,7);
        presentationGraph.connectMutual("i","g",6,6);

        presentationGraph.connectMutual("i","c",2,2);
        presentationGraph.connectMutual("c","f",4,4);

        presentationGraph.connectMutual("h","b",11,11);
        presentationGraph.connectMutual("d","f",14,14);

        return presentationGraph;
    }
}
