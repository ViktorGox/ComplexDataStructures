import LinkedList.LinkedList;
import Stations.Station;
import Tracks.Track;

public class Main {
    public static void main(String[] args) {
        Station.GenerateStationList();
        Track.GenerateTrackList();

        LinkedList<String> list = new LinkedList<String>();
        list.add("el1");
        list.add("el2");
        list.add("el3");

        System.out.println(list);
        System.out.println();

        list.add("el4",0);
        list.add("el5",3);
        list.add("el6",3);
        list.add("el7",0);

        System.out.println(list);
    }
}