import LinkedList.LinkedList;
import Sorting.InsertionSort;
import Sorting.ISortMethod;
import Sorting.QuickSort;
import Stations.Station;
import Tracks.Track;

public class Main {
    public static void main(String[] args) {
        Station.GenerateStationList();
        Track.GenerateTrackList();

        ISortMethod<String> sortMethod = new QuickSort<>();
        LinkedList<String> unsortedList = new LinkedList<String>();
        unsortedList.add("2");
        unsortedList.add("4");
        unsortedList.add("1");
        unsortedList.add("3");

        LinkedList<String> linkedList = LinkedList.sort(unsortedList, sortMethod, new String[unsortedList.size()]);

        System.out.println(linkedList);
    }
}