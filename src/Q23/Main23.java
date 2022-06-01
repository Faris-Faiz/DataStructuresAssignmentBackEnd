package Q23;

import java.util.*;

import extraFeature5.Building;
import extraFeature5.Tree;
import extraFeature5.Vertex;
import Q24.shortestPath;


public class Main23 {

    public static void main(String[] args) {
        int time = 0;
        shortestPath path = new shortestPath();

        int v = 8;

        // Adjacency list for storing which vertices are connected
        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // Creating graph given in the above diagram.
        // add_edge function takes adjacency list, source
        // and destination vertex as argument and forms
        // an edge between them.
        path.addEdge(adj, 0, 1);
        path.addEdge(adj, 0, 3);
        path.addEdge(adj, 1, 2);
        path.addEdge(adj, 3, 4);
        path.addEdge(adj, 3, 7);
        path.addEdge(adj, 4, 5);
        path.addEdge(adj, 4, 6);
        path.addEdge(adj, 4, 7);
        path.addEdge(adj, 5, 6);
        path.addEdge(adj, 6, 7);
        generateTitan t = new generateTitan();
      

        Scanner input = new Scanner(System.in);
        ArrayList<Integer> buildingNodes = new ArrayList<>(Arrays.asList(2,3,4));


        System.out.println("Choose a soldier: ");

        System.out.print("Enter number of titans: ");
        int numTitans = input.nextInt();


        // m.getTitanVertex();

        if (numTitans > 6) {
            System.out.println("Invalid num of titans");
        } else {
            ArrayList<Pair> titans = t.generateTitan(numTitans);

            System.out.println();
            System.out.println("adding titans...");

            t.addTitan(2, titans);
            PriorityQueue<Pair> sorted = t.sortTitan(titans);
            t.calculateDistance(sorted);

            Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7 };
//
            List<Integer> intList = Arrays.asList(intArray);

            Collections.shuffle(intList);
//
            intList.toArray(intArray);


            //place titans in the map
            for (int i = 0; i < t.getNumTitans(); i++) {
                //set random starting location
                Titan titan = t.getSorted().get(i).getValue();
                titan.setLocation((int)randomInt(1,7));
                //print out lcoation
                System.out.println("Starting location: " + titan.getLocation());
                //finds shortest path to the titan
                //set path of titan





                titan.setPath(intArray);
//               print out titan path
                System.out.println("Path of titan " + t.getSorted().get(i).getIndex() + ": " + Arrays.toString(titan.getPath()));
                System.out.print("Shortest path: ");
                path.printShortestDistance(adj, 0, titan.getLocation(), v);



                //get location has to be the last element in path array
//
                //time and location
                int j = 0;
                while (time < 12) {
                    System.out.println("Time:" + time);
                    if (time % 2 == 0) {
                        //set location(i) to array(i)
                        System.out.println("---Titan moves---");
                        titan.setLocation(titan.getPath()[j + 1]);
                        System.out.println("Titan" + t.getSorted().get(i).getIndex() + " Move to: " + titan.getLocation());
                        j++;



                    } else {
                        System.out.println("----Player moves-----");



                        path.printShortestDistance(adj, titan.getPath()[j - 1], titan.getLocation(), v);





                        System.out.println("\nReal battle is here");


                        // Vertex two =  res.aStar(titan.getPath()[j-1],titan.getLocation());
                        // Vertex three = res.aStar(m.getHead(),titan.getLocation())


                        //player.setLocation(titan.currentLocation)

                    }
                    time++;

                }
                //reset time back to 0
                time = 0;

                System.out.println();


            }






        }


    }
    public static double randomInt(double min, double max) {

        double random = (max - min + 1) * Math.random() + min;
        return random;

    }

    public static Vertex getVertex(Vertex[] array) {
        Random generator = new Random();
        int rnd = generator.nextInt(array.length);
        return array[rnd];
    }



}