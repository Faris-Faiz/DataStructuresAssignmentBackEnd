package Q23;

import Q24.VertexList;
import Q24.generateMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main23 {

    public static void main(String[] args) {
        //print map first
        VertexList res = new VertexList();
        generateMap m = new generateMap();
        m.printMap();
        //generate titans
        generateTitan t = new generateTitan();




        Scanner input= new Scanner(System.in);



        System.out.println("Choose a soldier: ");

        System.out.print("Enter number of titans: ");
        int numTitans = input.nextInt();



        //work in progresss - make it invalid if user inputs more titans than nodes in the map

        if(numTitans>6){
            System.out.println("Invalid num of titans");
        }else {
           ArrayList<Pair> titans = t.generateTitan(numTitans);
//            t.calculateDistance(titans);

//            for (int i = 0; i < numTitans; i++) {
//                m.findPath();
//                System.out.println();
//            }
            System.out.println();
            System.out.println("adding titans...");

            t.addTitan(2,titans);
            PriorityQueue<Pair> sorted = t.sortTitan(titans);
            t.calculateDistance(sorted);
            //to get a titan
            System.out.println(t.getSorted().get(0).getValue());

            //attack sequence
            //then add more titans
            //check queue again to see if should run or attack
        }

        //method to add the new titans into current items

        //soldier1.kill(titanIndex)
        //how to get titan to from list
//        System.out.println(t.getSorted().get(0).getValue());


    }
}
