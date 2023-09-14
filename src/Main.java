import LinkedList.LinkedList;
import Sorting.InsertionSort;
import Sorting.ISortMethod;
import Stations.Station;
import Tracks.Track;

public class Main {
    public static void main(String[] args) {
        Station.GenerateStationList();
        Track.GenerateTrackList();

        ISortMethod<String> sortMethod = new InsertionSort<>();
        LinkedList<String> unsortedList = new LinkedList<String>();
        unsortedList = LinkedList.sort(unsortedList, sortMethod, new String[unsortedList.size()]);
    }
}