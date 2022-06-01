package Q23;

import Q21andQ22.DoublyLinkedList;
import Q21andQ22.characteristics;
//import Q24.generateMap;
import Q24.shortestPath;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.*;

public class Main231 {

    public static void main(String[] args) {
        DoublyLinkedList<String> listchar = new DoublyLinkedList<String>();
        DoublyLinkedList<characteristics> list = new DoublyLinkedList<characteristics>();
        DoublyLinkedList<characteristics> listSoldier = new DoublyLinkedList<characteristics>();
        System.out.println("------Soldiers Available------");
        try {

            FileReader fr = new FileReader("ereh.txt");
            Scanner myReader = new Scanner(fr);
            while (myReader.hasNextLine()) {
                String data = null;
                data = myReader.nextLine();

                int i2 = 0;
                int i = 0;
                listchar.clear();
                for (String s : data.split(" ")) {


                    listchar.add(i, s);
                    i++;


                }
                String name = listchar.remove(0) + " " + listchar.remove(0);

                String height = listchar.remove(0);
                String weight = listchar.remove(0);
                String strength = listchar.remove(0);
                String agility = listchar.remove(0);
                String intel = listchar.remove(0);
                String coor = listchar.remove(0);
                String lead = listchar.remove(0);
                characteristics character = new characteristics(name, height, weight, strength, agility, intel, coor, lead);
                list.add(i2, character);


            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
        System.out.println("");
        int time = 0;
        //print map first
//        VertexList res = new VertexList();
//        generateMap m = new generateMap();
//        m.createMap();
        //generate titans
        generateTitan t = new generateTitan();

        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Choose a soldier: ");
        String soldierChose = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            String s = list.show(i).getName();
            if(s.equalsIgnoreCase(soldierChose)){

                     String name = list.show(i).getName();
                     String height = list.show(i).getHeight();
                     String weight = list.show(i).getWeight();
                     String strength = list.show(i).getStrength();
                     String agility = list.show(i).getAgility();
                     String intel = list.show(i).getIntel();
                     String coor = list.show(i).getCoor();
                     String lead = list.show(i).getLead();
                     characteristics character = new characteristics(name, height, weight, strength, agility, intel, coor, lead);
                        listSoldier.add(0, character);

                }


        }
        int StrengthSoldier = Integer.parseInt(listSoldier.show(0).getStrength());
        int AgilitySoldier = Integer.parseInt(listSoldier.show(0).getAgility());
        int CoorSoldier = Integer.parseInt(listSoldier.show(0).getCoor());
        int IntelSoldier = Integer.parseInt(listSoldier.show(0).getIntel());

        int sumStrengthAgility = StrengthSoldier + AgilitySoldier;
        System.out.println("");
        System.out.println("Value of " + soldierChose + "'s strength + agility : " + sumStrengthAgility);

        System.out.println("");

        System.out.print("Enter number of titans: ");
        int numTitans = input.nextInt();

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




        if (numTitans > 6) {
            System.out.println("Invalid num of titans");
        } else {
            ArrayList<Pair> titans = t.generateTitan(numTitans);

            System.out.println();
            System.out.println("adding titans...");

            t.addTitan(2, titans);
            PriorityQueue<Pair> sorted = t.sortTitan(titans);
            int highestrisk = sorted.peek().getPairRisk();
            System.out.println("\n\nThe highest risk titan is Titan "+sorted.peek().getIndex()+ "");
            //t.calculateDistance(sorted);
            //int highestrisk = sorted.peek().getPairRisk();
            if(sumStrengthAgility<highestrisk){
               System.out.println("\n------The danger risk of titan is too high! You will die if you continue!------");

                System.out.println("\nEnter 'C' to continue or 'R' to run : ");
                String userinput = sc.nextLine();
                if(userinput.equalsIgnoreCase("r")){
                    System.out.println("\n------You have outrun the titan, therefore you survived!------");
                    System.exit(0);
                }
                if(userinput.equalsIgnoreCase("c")){
                    System.out.println("\n------You chose to continue, the titan ate you.------");
                    System.exit(0);
                }
            }
            if(sumStrengthAgility>=highestrisk){
                System.out.println("\n"+"------"+soldierChose + " will kill the titans.------");
                System.out.println("");
                t.calculateDistance(sorted);

            //System.out.println("risk : "+t.getRisk());
            System.out.println("num of titans : " + t.getNumTitans());

                //place titans in the map
                for (int i = 0; i < t.getNumTitans(); i++) {
                    //set random starting location
                    Titan titan = t.getSorted().get(i).getValue();
                    titan.setLocation((int)randomInt(1,7));
                    //print out lcoation
                    System.out.println("Starting location: " + titan.getLocation());
                    //finds shortest path to the titan
                    //set path of titan

                    //List<Vertex> list = Arrays.asList(m.getArray());
                    //Collections.shuffle(adj);
                    Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7 };

                    List<Integer> intList = Arrays.asList(intArray);

                    Collections.shuffle(intList);

                    intList.toArray(intArray);


                    titan.setPath(intArray);
//               print out titan path
                    System.out.println("Path of titan " + t.getSorted().get(i).getIndex() + ": " + Arrays.toString(titan.getPath()));
                    System.out.print("Shortest path: ");
                    path.printShortestDistance(adj, 0, titan.getLocation(), v);


//                Vertex one =res.aStar(m.getHead(),titan.getLocation());
//                res.printPath(one);

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
//                            if(CoorSoldier < 5 && path.isBuilding()) time+=3;


                            System.out.println("\nReal battle is here");


                            // Vertex two =  res.aStar(titan.getPath()[j-1],titan.getLocation());
                            // Vertex three = res.aStar(m.getHead(),titan.getLocation())


                            //player.setLocation(titan.currentLocation)

                        }
                        time++;




                    }
                    //reset time back to 0
                    time = 0;
                    Titan beast = new nineTitan();
                    beast.setLocation((int)randomInt(1,7));
                    System.out.println("Beast is at " + beast.getLocation());
                    path.printShortestDistance(adj, titan.getPath()[j - 1], beast.getLocation(), v);
                    if(CoorSoldier< 5 && path.isBuilding()) time+=3;
                    else if(CoorSoldier<8) time+=2;
                    else time +=1;

                    if(IntelSoldier< 5 && titan.getLocation()==0) time+=3;
                    else if(IntelSoldier<8) time+=2;
                    else time +=1;

                    if(AgilitySoldier< 5 && path.isTree()) time+=3;
                    else if(AgilitySoldier<8) time+=2;
                    else time +=1;

                    System.out.println("\nTotal time " + time);




                    System.out.println();


                }

            }

        }
//        Titan beast = new nineTitan();
//        beast.setLocation((int)randomInt(1,7));
//        System.out.println("Beast Titan at node " + beast.getLocation());
//        System.out.print("Choose a soldier: ");
//        String newsoldierChose = sc.nextLine();
//        for (int i = 0; i < list.size(); i++) {
//            String s = list.show(i).getName();
//            if(s.equalsIgnoreCase(newsoldierChose)){
//
//                String name = list.show(i).getName();
//                String height = list.show(i).getHeight();
//                String weight = list.show(i).getWeight();
//                String strength = list.show(i).getStrength();
//                String agility = list.show(i).getAgility();
//                String intel = list.show(i).getIntel();
//                String coor = list.show(i).getCoor();
//                String lead = list.show(i).getLead();
//                characteristics character = new characteristics(name, height, weight, strength, agility, intel, coor, lead);
//                listSoldier.add(0, character);
//
//            }
//
//
//        }
//
//
//
//        path.printShortestDistance(adj,0, beast.getLocation(), v);
//        if(CoorSoldier < 5 && path.isBuilding()) time+=3;



    }
    public static double randomInt(double min, double max) {

        double random = (max - min + 1) * Math.random() + min;
        return random;

    }


}