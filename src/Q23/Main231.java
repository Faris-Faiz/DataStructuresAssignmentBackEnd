package Q23;

import Q21andQ22.DoublyLinkedList;
import Q21andQ22.Node;
import Q21andQ22.SortList;
import Q21andQ22.assignmentaotDania;
import Q21andQ22.characteristics;
import Q24.Vertex;
import Q24.VertexList;
import Q24.generateMap;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

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
        VertexList res = new VertexList();
        generateMap m = new generateMap();
        m.printMap();
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
        int sumStrengthAgility = StrengthSoldier + AgilitySoldier;
        System.out.println("");
        System.out.println("Value of " + soldierChose + "'s strength + agility : " + sumStrengthAgility);
        
        System.out.println("");                  
        
        System.out.print("Enter number of titans: ");
        int numTitans = input.nextInt();
        
        
        m.getVertex();

        if (numTitans > m.getArray().length) {
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
                titan.setLocation(m.getVertex());
                //print out lcoation
                System.out.println("Staring location: " + titan.getLocation());
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
}