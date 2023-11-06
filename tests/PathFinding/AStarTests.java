package PathFinding;

import Exceptions.DestinationNotReachable;
import Stations.Station;
import org.junit.jupiter.api.Test;

public class AStarTests {

    @Test
    public void someTestingMethod() {
        try {
            AStar<String> aStar = new AStar<>(Station.generateStationGraph(), "DV", "EHV", Station::calculateDistanceBetween);
            aStar.calculatePath();
        } catch (DestinationNotReachable e) {
            System.err.println(e);
        }
    }
}