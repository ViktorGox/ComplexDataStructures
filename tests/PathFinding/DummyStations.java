package PathFinding;

import Exceptions.CountryNotSupported;
import MyCollections.Graph.Graph;
import Stations.Station;
import Tracks.Track;

public class DummyStations {
    public static Graph<String> getDummyStationGraphForAStar() throws CountryNotSupported {
        Station.addStationToList(new Station((short) 1, "F1", "dummyName", "NL", "type", 6.0, 1.0));
        Station.addStationToList(new Station((short) 1, "F6", "dummyName", "NL", "type", 6.0, 6.0));

        Station.addStationToList(new Station((short) 1, "E1", "dummyName", "NL", "type", 5.0, 1.0));
        Station.addStationToList(new Station((short) 1, "E4", "dummyName", "NL", "type", 5.0, 4.0));
        Station.addStationToList(new Station((short) 1, "E5", "dummyName", "NL", "type", 5.0, 5.0));

        Station.addStationToList(new Station((short) 1, "D1", "dummyName", "NL", "type", 4.0, 1.0));
        Station.addStationToList(new Station((short) 1, "D4", "dummyName", "NL", "type", 4.0, 4.0));
        Station.addStationToList(new Station((short) 1, "D5", "dummyName", "NL", "type", 4.0, 5.0));

        Station.addStationToList(new Station((short) 1, "C1", "dummyName", "NL", "type", 3.0, 1.0));
        Station.addStationToList(new Station((short) 1, "C3", "dummyName", "NL", "type", 3.0, 3.0));
        Station.addStationToList(new Station((short) 1, "C4", "dummyName", "NL", "type", 3.0, 4.0));
        Station.addStationToList(new Station((short) 1, "C5", "dummyName", "NL", "type", 3.0, 5.0));

        Station.addStationToList(new Station((short) 1, "B1", "dummyName", "NL", "type", 2.0, 1.0));
        Station.addStationToList(new Station((short) 1, "B2", "dummyName", "NL", "type", 2.0, 2.0));
        Station.addStationToList(new Station((short) 1, "B4", "dummyName", "NL", "type", 2.0, 4.0));
        Station.addStationToList(new Station((short) 1, "B5", "dummyName", "NL", "type", 2.0, 5.0));
        Station.addStationToList(new Station((short) 1, "B6", "dummyName", "NL", "type", 2.0, 6.0));

        Station.addStationToList(new Station((short) 1, "A1", "dummyName", "NL", "type", 1.0, 1.0));
        Station.addStationToList(new Station((short) 1, "A2", "dummyName", "NL", "type", 1.0, 2.0));
        Station.addStationToList(new Station((short) 1, "A3", "dummyName", "NL", "type", 1.0, 3.0));
        Station.addStationToList(new Station((short) 1, "A4", "dummyName", "NL", "type", 1.0, 4.0));


        Track.addTrackToList(new Track("F6", "E5", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("D4", "E5", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("D4", "C4", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("D4", "C3", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("C4", "B4", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("B4", "B5", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("F6", "E5", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("B4", "A4", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("B4", "A3", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("C3", "B2", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("A3", "A2", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("A2", "A1", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("A1", "B1", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("B1", "C1", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("C1", "D1", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("D1", "E1", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("E1", "F1", (short) 1, (short) 1, "DummyType"));


        // now in reverse
        Track.addTrackToList(new Track("E5", "F6", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("E5", "D4", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("C4", "D4", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("C3", "D4", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("B4", "C4", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("B5", "B4", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("E5", "F6", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("A4", "B4", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("A3", "B4", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("B2", "C3", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("A2", "A3", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("A1", "A2", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("B1", "A1", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("C1", "B1", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("D1", "C1", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("E1", "D1", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("F1", "E1", (short) 1, (short) 1, "DummyType"));


        return Station.generateStationGraph();
    }

    public static Graph<String> getDummyStationGraphForKruskal() throws CountryNotSupported {
        Station.addStationToList(new Station((short) 1, "A", "dummyName", "NL", "type", 5.0, 1.0));
        Station.addStationToList(new Station((short) 1, "B", "dummyName", "NL", "type", 4.0, 2.0));
        Station.addStationToList(new Station((short) 1, "C", "dummyName", "NL", "type", 4.0, 4.0));
        Station.addStationToList(new Station((short) 1, "D", "dummyName", "NL", "type", 4.0, 6.0));
        Station.addStationToList(new Station((short) 1, "E", "dummyName", "NL", "type", 5.0, 7.0));
        Station.addStationToList(new Station((short) 1, "F", "dummyName", "NL", "type", 6.0, 6.0));
        Station.addStationToList(new Station((short) 1, "G", "dummyName", "NL", "type", 6.0, 4.0));
        Station.addStationToList(new Station((short) 1, "H", "dummyName", "NL", "type", 6.0, 2.0));
        Station.addStationToList(new Station((short) 1, "I", "dummyName", "NL", "type", 5.0, 3.0));
        Station.addStationToList(new Station((short) 1, "J", "dummyName", "NL", "type", 3.0, 1.0));
        Station.addStationToList(new Station((short) 1, "K", "dummyName", "NL", "type", 4.0, 1.0));
        Station.addStationToList(new Station((short) 1, "L", "dummyName", "NL", "type", 6.0, 7.0));
        Station.addStationToList(new Station((short) 1, "M", "dummyName", "NL", "type", 8.0, 2.0));
        Station.addStationToList(new Station((short) 1, "N", "dummyName", "NL", "type", 2.0, 3.0));
        Station.addStationToList(new Station((short) 1, "O", "dummyName", "NL", "type", 2.0, 5.0));
        Station.addStationToList(new Station((short) 1, "P", "dummyName", "NL", "type", 5.0, 4.0));


        Track.addTrackToList(new Track("A", "B", (short) 4, (short) 4, "DummyType"));
        Track.addTrackToList(new Track("A", "H", (short) 9, (short) 9, "DummyType"));
        Track.addTrackToList(new Track("A", "K", (short) 13, (short) 13, "DummyType"));
        Track.addTrackToList(new Track("B", "J", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("B", "C", (short) 8, (short) 8, "DummyType"));
        Track.addTrackToList(new Track("B", "H", (short) 11, (short) 11, "DummyType"));
        Track.addTrackToList(new Track("C", "D", (short) 7, (short) 7, "DummyType"));
        Track.addTrackToList(new Track("C", "F", (short) 4, (short) 4, "DummyType"));
        Track.addTrackToList(new Track("C", "I", (short) 2, (short) 2, "DummyType"));
        Track.addTrackToList(new Track("D", "F", (short) 14, (short) 14, "DummyType"));
        Track.addTrackToList(new Track("D", "E", (short) 9, (short) 9, "DummyType"));
        Track.addTrackToList(new Track("E", "F", (short) 10, (short) 10, "DummyType"));
        Track.addTrackToList(new Track("E", "L", (short) 15, (short) 15, "DummyType"));
        Track.addTrackToList(new Track("F", "G", (short) 2, (short) 2, "DummyType"));
        Track.addTrackToList(new Track("G", "I", (short) 6, (short) 6, "DummyType"));
        Track.addTrackToList(new Track("G", "H", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("H", "I", (short) 7, (short) 7, "DummyType"));
        Track.addTrackToList(new Track("H", "M", (short) 2, (short) 2, "DummyType"));
        Track.addTrackToList(new Track("C", "N", (short) 2, (short) 2, "DummyType"));
        Track.addTrackToList(new Track("C", "O", (short) 2, (short) 2, "DummyType"));


        Track.addTrackToList(new Track("B", "A", (short) 4, (short) 4, "DummyType"));
        Track.addTrackToList(new Track("H", "A", (short) 9, (short) 9, "DummyType"));
        Track.addTrackToList(new Track("K", "A", (short) 13, (short) 13, "DummyType"));
        Track.addTrackToList(new Track("J", "B", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("C", "B", (short) 8, (short) 8, "DummyType"));
        Track.addTrackToList(new Track("H", "B", (short) 11, (short) 11, "DummyType"));
        Track.addTrackToList(new Track("D", "C", (short) 7, (short) 7, "DummyType"));
        Track.addTrackToList(new Track("F", "C", (short) 4, (short) 4, "DummyType"));
        Track.addTrackToList(new Track("I", "C", (short) 2, (short) 2, "DummyType"));
        Track.addTrackToList(new Track("F", "D", (short) 14, (short) 14, "DummyType"));
        Track.addTrackToList(new Track("E", "D", (short) 9, (short) 9, "DummyType"));
        Track.addTrackToList(new Track("F", "E", (short) 10, (short) 10, "DummyType"));
        Track.addTrackToList(new Track("L", "E", (short) 15, (short) 15, "DummyType"));
        Track.addTrackToList(new Track("G", "F", (short) 2, (short) 2, "DummyType"));
        Track.addTrackToList(new Track("I", "G", (short) 6, (short) 6, "DummyType"));
        Track.addTrackToList(new Track("H", "G", (short) 1, (short) 1, "DummyType"));
        Track.addTrackToList(new Track("I", "H", (short) 7, (short) 7, "DummyType"));
        Track.addTrackToList(new Track("M", "H", (short) 2, (short) 2, "DummyType"));
        Track.addTrackToList(new Track("N", "C", (short) 2, (short) 2, "DummyType"));
        Track.addTrackToList(new Track("O", "C", (short) 2, (short) 2, "DummyType"));

        return Station.generateStationGraph();
    }
}
