package PathFinding.Astar;

import Exceptions.DestinationNotReachable;
import PathFinding.DummyStations;
import PathFinding.PathFindNode;
import Stations.Station;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AStarTests {
    @Test
    public void AStarWithDummyStations_GoFromF6ToF1_ReturnsCorrectPath() {
        try {
            AStar<String> aStar = new AStar<>(DummyStations.getDummyStationGraphForAStar(), "F6", "F1", Station::calculateDistanceBetween);

            ArrayList<PathFindNode<String>> result = aStar.calculatePath();
            assertEquals("E1", result.get(0).getOrigin());
            assertEquals("D1", result.get(1).getOrigin());
            assertEquals("C1", result.get(2).getOrigin());
            assertEquals("B1", result.get(3).getOrigin());
            assertEquals("A1", result.get(4).getOrigin());
            assertEquals("A2", result.get(5).getOrigin());
            assertEquals("A3", result.get(6).getOrigin());
            assertEquals("B4", result.get(7).getOrigin());
            assertEquals("C4", result.get(8).getOrigin());
            assertEquals("D4", result.get(9).getOrigin());
            assertEquals("E5", result.get(10).getOrigin());
            assertEquals("F6", result.get(11).getOrigin());


        } catch (DestinationNotReachable e) {
            System.err.println(e);
        }
    }

    @Test
    public void AStarWithDummyStations_CallingMulitpleTimes_ReturnsCorrectPathAllTimes() {
        try {
            AStar<String> aStar = new AStar<>(DummyStations.getDummyStationGraphForAStar(), "F6", "F1", Station::calculateDistanceBetween);

            ArrayList<PathFindNode<String>> result = aStar.calculatePath();
            assertEquals("E1", result.get(0).getOrigin());
            assertEquals("D1", result.get(1).getOrigin());
            assertEquals("C1", result.get(2).getOrigin());
            assertEquals("B1", result.get(3).getOrigin());
            assertEquals("A1", result.get(4).getOrigin());
            assertEquals("A2", result.get(5).getOrigin());
            assertEquals("A3", result.get(6).getOrigin());
            assertEquals("B4", result.get(7).getOrigin());
            assertEquals("C4", result.get(8).getOrigin());
            assertEquals("D4", result.get(9).getOrigin());
            assertEquals("E5", result.get(10).getOrigin());
            assertEquals("F6", result.get(11).getOrigin());

            ArrayList<PathFindNode<String>> result2 = aStar.calculatePath("F1", "F6");
            assertEquals("E5", result2.get(0).getOrigin());
            assertEquals("D4", result2.get(1).getOrigin());
            assertEquals("C4", result2.get(2).getOrigin());
            assertEquals("B4", result2.get(3).getOrigin());
            assertEquals("A3", result2.get(4).getOrigin());
            assertEquals("A2", result2.get(5).getOrigin());
            assertEquals("A1", result2.get(6).getOrigin());
            assertEquals("B1", result2.get(7).getOrigin());
            assertEquals("C1", result2.get(8).getOrigin());
            assertEquals("D1", result2.get(9).getOrigin());
            assertEquals("E1", result2.get(10).getOrigin());
            assertEquals("F1", result2.get(11).getOrigin());

            ArrayList<PathFindNode<String>> result3 = aStar.calculatePath("F6", "F1");
            assertEquals("E1", result3.get(0).getOrigin());
            assertEquals("D1", result3.get(1).getOrigin());
            assertEquals("C1", result3.get(2).getOrigin());
            assertEquals("B1", result3.get(3).getOrigin());
            assertEquals("A1", result3.get(4).getOrigin());
            assertEquals("A2", result3.get(5).getOrigin());
            assertEquals("A3", result3.get(6).getOrigin());
            assertEquals("B4", result3.get(7).getOrigin());
            assertEquals("C4", result3.get(8).getOrigin());
            assertEquals("D4", result3.get(9).getOrigin());
            assertEquals("E5", result3.get(10).getOrigin());
            assertEquals("F6", result3.get(11).getOrigin());


        } catch (DestinationNotReachable e) {
            System.err.println(e);
        }
    }

    @Test
    public void AStarWithDummyStations_PathFindToNodeThatIsNotConnected_ReturnsUnreachableDestination(){
        AStar<String> aStar = new AStar<>(DummyStations.getDummyStationGraphForAStar(), "F6", "B6", Station::calculateDistanceBetween);

        assertThrows(DestinationNotReachable.class, aStar::calculatePath);
    }

    @Test
    public void AStarWithDummyStations_PathFindFromOrToNonExistantNode_ReturnsNull() throws DestinationNotReachable {
        AStar<String> aStar = new AStar<>(DummyStations.getDummyStationGraphForAStar(), "A0", "F6", Station::calculateDistanceBetween);
        assertNull(aStar.calculatePath());
        assertNull(aStar.calculatePath("A1", "F0"));
    }
}