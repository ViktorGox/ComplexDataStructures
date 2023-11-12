import Exceptions.DestinationNotReachable;
import PathFinding.Astar.AStar;
import PathFinding.Dijkstra.Dijkstra;
import PathFinding.Kruskal.Kruskal;
import PathFinding.PathFindNode;
import Stations.Station;
import Tracks.Track;

import java.util.ArrayList;
import java.util.Arrays;
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
                    System.out.println(Arrays.toString(Track.sortInsertion()));
                    break;
                case "4":
                    System.out.println(Arrays.toString(Track.sortQuick()));
                    break;
                case "5":
                    // get from avl tree
                    break;
                case "6":
                    searchInHashMapByCode();
                    break;
                case "7":
                    performKruskal();
                    break;
                case "8":
                    findPathAStar();
                    break;
                case "9":
                    findPathDijkstra();
                    break;
            }
            c = s.nextLine().toLowerCase();
        }
    }

    private void searchInHashMapByCode() {
        System.out.println("Code in capital letters");
        String code = s.nextLine();
        System.out.println(Station.getStationByCode(code));
    }

    private void searchBinary() {
        System.out.println("Station name");
        String stationName = s.nextLine();
        System.out.println(Station.searchForStationBinarySearch(stationName));
    }

    private void searchLinear() {
        System.out.println("Station name");
        String stationName = s.nextLine();
        System.out.println(Station.getStationLinear(stationName));
    }

    private void performKruskal() {
        System.out.println("Station code 1");
        String code1 = s.nextLine();

        System.out.println("Station code 2");
        String code2 = s.nextLine();

        Kruskal<String> kruskal = new Kruskal<>(Station.generateStationGraph(), Station::getGeoLat, Station::getGeoLng, code1, code2);
        System.out.println(kruskal.calculatePath().toGraphViz());
    }

    private void findPathAStar() {
        System.out.println("Station code 1");
        String code1 = s.nextLine();

        System.out.println("Station code 2");
        String code2 = s.nextLine();


        AStar<String> aStar = new AStar<>(Station.generateStationGraph(), code1, code2, Station::calculateDistanceBetween);
        try {
            System.out.println(aStar.calculatePath());
        } catch (DestinationNotReachable e) {
            System.out.println("Path was not found. Destination not on graph, or no path to it.");
        }
    }

    private void findPathDijkstra() {
        System.out.println("Station code 1");
        String code1 = s.nextLine();

        System.out.println("Station code 2");
        String code2 = s.nextLine();


        Dijkstra<String> dijkstra = new Dijkstra<>(Station.generateStationGraph(), code1, code2);
        try {
            ArrayList<PathFindNode<String>> result = dijkstra.calculatePath();
            System.out.println(result);
            System.out.println("Total weight: " + result.get(0).getCost());

        } catch (DestinationNotReachable e) {
            System.out.println("Path was not found. Destination not on graph, or no path to it.");
        }
    }
}