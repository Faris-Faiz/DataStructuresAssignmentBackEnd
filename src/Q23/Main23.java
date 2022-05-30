package Q23;

import Q24.Vertex;
import Q24.VertexList;
import Q24.generateMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main23 {

    public static void main(String[] args) {
        int time = 0;
        //print map first
        VertexList res = new VertexList();
        generateMap m = new generateMap();
        m.createMap();
        //generate titans
        generateTitan t = new generateTitan();

        Scanner input = new Scanner(System.in);


        System.out.println("Choose a soldier: ");

        System.out.print("Enter number of titans: ");
        int numTitans = input.nextInt();


        m.getTitanVertex();

        if (numTitans > m.getArray().length) {
            System.out.println("Invalid num of titans");
        } else {
            ArrayList<Pair> titans = t.generateTitan(numTitans);

            System.out.println();
            System.out.println("adding titans...");

            t.addTitan(2, titans);
            PriorityQueue<Pair> sorted = t.sortTitan(titans);
            t.calculateDistance(sorted);


            //place titans in the map
            for (int i = 0; i < t.getNumTitans(); i++) {
                //set random starting location
                Titan titan = t.getSorted().get(i).getValue();
                titan.setLocation(m.getTitanVertex());
                //print out lcoation
                System.out.println("Starting location: " + titan.getLocation());
                //finds shortest path to the titan
                //set path of titan
               titan.setPath(m.getArray());
//               print out titan path
                System.out.println("Path of titan " + t.getSorted().get(i).getIndex() + ": " + Arrays.toString(titan.getPath()));
                System.out.print("Shortest path: ");m.findPath(titan.getLocation());
                //get location has to be the last element in path array
//
                //time and location
                int j = 0;
                while (time < 12) {
                    System.out.println("Time:" + time);
                    if (time % 2 == 0) {
                        //set location(i) to array(i)

                        titan.setLocation(titan.getPath()[j]);
                        System.out.println("Titan" + t.getSorted().get(i).getIndex() + " Move: " + titan.getLocation());
                        j++;



                    } else {
                        System.out.println("Player moves");
                        //how to configure players moves?
                        m.findPath(titan.getLocation());
                        //player.setLocation(titan.currentLocation)

                    }
                    time++;
                }
                //reset time back to 0
                time = 0;

                System.out.println();


                //attack sequence
                //then add more titans
                //check queue again to see if should run or attack
            }


//        System.out.println(t.getSorted().get(0).getValue());


        }
    }
}
