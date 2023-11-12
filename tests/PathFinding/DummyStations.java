package PathFinding;

import Exceptions.CountryNotSupported;
import MyCollections.Graph.Graph;
import Stations.Station;
import Tracks.Track;

public class DummyStations {
    public static Graph<String> getDummyStationGraph() throws CountryNotSupported {
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
}
