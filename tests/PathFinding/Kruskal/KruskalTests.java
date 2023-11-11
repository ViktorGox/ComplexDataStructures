package PathFinding.Kruskal;

import Stations.Station;
import org.junit.jupiter.api.Test;

public class KruskalTests {

    @Test
    public void GetLatTest() {
        Kruskal<String> kruskal = new Kruskal<>(Station.generateStationGraph(), Station::getGeoLat, Station::getGeoLng, "APD", "EHV");
        System.out.println(kruskal.calculatePath().toGraphViz());
    }
}
