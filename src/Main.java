import Stations.Station;
import Tracks.Track;

import java.util.Scanner;

public class Main {

    private Scanner s;
    private final String help = "Commands:\n" +
            "\n" +
            "1: Search stations by name with binary algorithm \n" +
            "2: Search stations by name in linear list \n" +
            "3: Sort connections by using Insertion Sort\n" +
            "4: Sort connections by using Quick Sort \n" +
            "5: Search station from AVL tree \n" +
            "6: Search for station by code from hash map \n" +
            "7: See list of nodes that fall in area between 2 stations \n" +
            "8: Find path to station using A* \n" +
            "9: Find path to station using Dijkstra \n" +
            "?: This help menu \n" +
            "Q: Quit\n";

    public static void main(String[] args) {
        Station.GenerateStationList();
        Track.GenerateTrackList();
        new Main().commandLoop();
    }

    public void commandLoop() {
        System.out.println(help);
        s = new Scanner(System.in);
        String c = s.nextLine().toLowerCase();
        while (!c.equals("q")) {
            switch (c) {
                case "?":
                    System.out.println(help);
                    break;
                case "1":
                    searchBinary();
                    break;
                case "2":
                    searchLinear();
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    break;
                case "9":
                    break;
            }
            c = s.nextLine().toLowerCase();
        }
    }

    private void searchBinary() {
        String stationName = s.nextLine();
        System.out.println(Station.searchForStationBinarySearch(stationName));
    }

    private void searchLinear() {
        String stationName = s.nextLine();
        System.out.println(Station.getStationLinear(stationName));
    }
}