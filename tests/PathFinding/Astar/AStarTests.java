package PathFinding.Astar;

import Exceptions.DestinationNotReachable;
import PathFinding.Astar.AStar;
import Stations.Station;
import org.junit.jupiter.api.Test;

public class AStarTests {
    @Test
    public void someTestingMethod() {
        try {
            AStar<String> aStar = new AStar<>(Station.generateStationGraph(), "DV", "EHV", Station::calculateDistanceBetween);
            System.out.println(aStar.calculatePath());
        } catch (DestinationNotReachable e) {
            System.err.println(e);
        }
    }
}