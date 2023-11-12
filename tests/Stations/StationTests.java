package Stations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StationTests {

    @Test
    public void TwoStationsWithSameCode_CheckEqualsResult_EqualReturnsTrue() {
        Station one = new Station((byte) 2, "one", "O.N.E", "NL", "thisone", 20.0, 24.0);
        Station two = new Station((byte) 3, "one", "W.N.O", "NL", "thatone", 21.0, 24.0);
        assertEquals(one, two);
    }

    @Test
    public void TwoStations_CalculateDistance_GivesCorrectResult() {
        Station one = new Station((byte) 2, "one", "O.N.E", "NL", "thisone", 20.0, 20.0);
        Station two = new Station((byte) 3, "two", "T.W.O", "NL", "thatone", 15.0, 30.0);
        Station three = new Station((byte) 2, "thr", "T.H.R", "NL", "thisone", 25.0, 30.0);
        Station four = new Station((byte) 3, "fou", "F.O.U", "NL", "thatone", 30.0, 30.0);

        Station.addStationToList(one);
        Station.addStationToList(two);
        Station.addStationToList(three);
        Station.addStationToList(four);

        assertEquals(10, Math.round(Station.calculateDistanceBetween(two.getCode(), three.getCode())),2);
        assertEquals(14.14, Math.round(Station.calculateDistanceBetween(one.getCode(), four.getCode())),2);
        assertEquals(11.18, Math.round(Station.calculateDistanceBetween(one.getCode(), three.getCode())),2);
        assertEquals(15, Math.round(Station.calculateDistanceBetween(two.getCode(), four.getCode())),2);
    }
}