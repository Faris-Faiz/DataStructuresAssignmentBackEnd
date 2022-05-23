package Q23;

import Q24.VertexList;
import Q24.generateMap;

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
        System.out.print("Enter number of titans: ");
        int numTitans = input.nextInt();


        //work in progresss - make it invalid if user inputs more titans than nodes in the map

        if(numTitans>6){
            System.out.println("Invalid num of titans");
        }else {
            t.generateTitans(numTitans);

            for (int i = 0; i < numTitans; i++) {
                m.findPath();
                System.out.println();
            }
            System.out.println();
        }
    }
}
