package PathFinding.Kruskal;

import PathFinding.DummyStations;
import Stations.Station;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KruskalTests {

    //TODO: provides the same result as the example from the presentation, excluding the addion of P L and K.
    @Test
    public void FindShortestConnectionsFromPresentationGraph() {
        Kruskal<String> kruskal = new Kruskal<>(DummyStations.getDummyStationGraphForKruskal(), Station::getGeoLat, Station::getGeoLng, "K", "L");
        assertEquals("A -> B [label=4.0]\n" +
                "A -> H [label=7.0]\n" +
                "A -> K [label=13.0]\n" +
                "B -> A [label=4.0]\n" +
                "C -> I [label=2.0]\n" +
                "C -> F [label=4.0]\n" +
                "C -> D [label=7.0]\n" +
                "D -> C [label=7.0]\n" +
                "D -> E [label=9.0]\n" +
                "E -> D [label=9.0]\n" +
                "E -> L [label=15.0]\n" +
                "F -> G [label=2.0]\n" +
                "F -> C [label=4.0]\n" +
                "G -> H [label=1.0]\n" +
                "G -> F [label=2.0]\n" +
                "H -> G [label=1.0]\n" +
                "H -> A [label=7.0]\n" +
                "I -> C [label=2.0]\n" +
                "K -> A [label=13.0]\n" +
                "L -> E [label=15.0]\n" +
                "P\n", kruskal.calculatePath().toGraphViz());
    }
}
