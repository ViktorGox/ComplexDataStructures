import LinkedList.LinkedList;
import Stations.Station;
import Tracks.Track;

public class Main {
    public static void main(String[] args) {
        Station.GenerateStationList();
        Track.GenerateTrackList();

        LinkedList<String> list = new LinkedList<String>();
        list.add("bingo bongo");
        list.add("bongo bingo");
        list.add("the end!");

        System.out.println(list);
    }
}