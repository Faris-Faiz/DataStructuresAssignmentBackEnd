package Q24;

import Q21andQ22.characterList;
import Q23.Pair;
import Q23.Titan;
import Q23.generateTitan;
import Q23.nineTitan;
import Q23Sequel.Hamiltonian;

import java.util.*;

public class Map {
    Scanner input = new Scanner(System.in);
    private shortestPath path = new shortestPath();
    private ArrayList<ArrayList<Integer>> adj;
    private ArrayList<Pair> titans;
    private PriorityQueue<Pair> sorted;
    private characterList list = new characterList();
    private generateTitan t = new generateTitan();



//    private PriorityQueue<Pair> sorted;
    private int numTitans;
    private int v;
    private int time =0;

    public int getTime() {
        return time;
    }

    public Map() {
    }

    public void generateMap() {

        v = 8;

        // Adjacency list for storing which vertices are connected
        adj =
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

    }

    public void createTitans(int numTitans) {


        titans = t.generateTitan(numTitans);


        System.out.println();
        System.out.println("adding titans...");

        t.addTitan(2, titans);





        }








    public void killTitans(String soldierChose, int SumStrengthAgility, int AgilitySoldier, int CoorSoldier){

        sorted = t.sortTitan(titans);


        int highestrisk = sorted.peek().getPairRisk();
        System.out.println("\n\nThe highest risk titan is Titan " + sorted.peek().getIndex() + "");



        if (SumStrengthAgility < highestrisk) {
            System.out.println("\n------The danger risk of titan is too high! You will die if you continue!------");

            System.out.println("\nEnter 'C' to continue or 'R' to run : ");
            String userinput = input.nextLine();
            if (userinput.equalsIgnoreCase("r")) {
                System.out.println("\n------You have outrun the titan, therefore you survived!------");
                System.exit(0);
            }
            if (userinput.equalsIgnoreCase("c")) {
                System.out.println("\n------You chose to continue, the titan ate you.------");
                System.exit(0);
            }
        }
        if (SumStrengthAgility >= highestrisk) {
            System.out.println("\n" + "------" + soldierChose + " will kill the titans.------");
            System.out.println("");
            t.calculateDistance(sorted);
        }

        Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7 };

        List<Integer> intList = Arrays.asList(intArray);

        Collections.shuffle(intList);

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

            System.out.println("\nPath of titan " + t.getSorted().get(i).getIndex() + ": " + Arrays.toString(titan.getPath()));
            System.out.print("\nShortest path: ");
            path.printShortestDistance(adj, 0, titan.getLocation(), v,0,0,0);



            //get location has to be the last element in path array
//
            //time and location
            int j = 0;
            while (time < 12) {

                if (time % 2 == 0) {
                    //set location(i) to array(i)
                    System.out.println("\n---Titan moves " + "(Time is: " + time + ")------");
                    titan.setLocation(titan.getPath()[j + 1]);
                    System.out.println("Titan" + t.getSorted().get(i).getIndex() + " Move to: " + titan.getLocation());
                    j++;



                } else {
                    System.out.println("\n----"+ soldierChose+ " moves " + "(Time is: " + time +")------");



                    path.printShortestDistance(adj, titan.getPath()[j - 1], titan.getLocation(), v,AgilitySoldier, CoorSoldier,time);
                    time = path.getTime();



                }
                time++;

            }

            //reset time back to 0
            time = 0;
            System.out.println("Titan is killed");

            System.out.println();


        }



    }

    public void scoutWall() {

        //vertices
        int[] vertices = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //adjacency matrix
        int[][] adjacencyMatrix = {{0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0}};

        int start = 0;
        System.out.println("\n" +
                "Captain Erwin gets the information from the garrison which there are some titans\n" +
                "invading the wall. Find out one point that can search all the points without any\n" +
                "repeating on the points. Then, getting back to that starting point\n");
        System.out.print("Enter Starting Point: ");
        Scanner input = new Scanner(System.in);
        start = input.nextInt();
        Hamiltonian hamiltonian = new Hamiltonian(start, vertices, adjacencyMatrix);
        hamiltonian.findCycle();

        //if there is no Hamiltonian Cycle
        if (!hamiltonian.isHasCycle()) {
            System.out.println("No Path Found.");
        }

    }

    public double randomInt(double min, double max) {

        double random = (max - min + 1) * Math.random() + min;
        return random;

    }
}
