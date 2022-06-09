import Q21andQ22.DoublyLinkedList;
import Q21andQ22.characterList;
import Q21andQ22.characteristics;
import Q23.Pair;
import Q23.generateTitan;
import Q24.Map;
import Q25.marleyWord;
import Q26.WallofMaria;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

// This is the CLI version of the Main File
public class Main {

    public static void main(String[] args) {
        int option = 0;
        Scanner input = new Scanner(System.in);

        do {
            if (option == 0){
                //clearScreen();
                System.out.println("Welcome to The World of Titan");
                System.out.println("--------------------------------");
                System.out.println("Option 1");
                System.out.println("Option 2");
                System.out.println("Option 3");
                System.out.println("Option 4");
                System.out.print("Please enter the option number (Enter -1 to exit): ");
                option = input.nextInt();

            } else if (option == 1){
                //clearScreen();
                //q2.1
                characterList list = new characterList();
                try {
                    list.readFile();
                }catch (Exception a){
                    System.out.println(a.getMessage());
                }
                list.printList();
                list.sortAbility();
                list.searchAbility();

                list.chooseSoldier();
                System.out.println(list.getSoldierChose());
                System.out.println(list.getSumStrengthAgility());

                //q2.3
                Map map = new Map();
                map.generateMap();

                map.createTitans(1);
                //q2.4
                map.killTitans(list.getSoldierChose(), list.getSumStrengthAgility(),list.getAgilitySoldier(), list.getCoorSoldier());
                pressAnyKeyToContinue();
                option = 0;

            } else if (option == 2) {
                //clearScreen();
                //q2.3
                Map map1 = new Map();
                map1.scoutWall();
                pressAnyKeyToContinue();
                option = 0;
            } else if (option == 3) {
                //clearScreen();
                //q2.5
                marleyWord word = new marleyWord();
                pressAnyKeyToContinue();
                option = 0;
            } else if (option == 4) {
                //clearScreen();
                //q2.6
                WallofMaria wall = new WallofMaria();
                pressAnyKeyToContinue();
                option = 0;
            } else if (option == -1) {
                break;
            } else {
                //clearScreen();
                System.out.println("Invalid option number !");
                pressAnyKeyToContinue();
                option = 0;
            }
        } while (option != -1);
    }

    private static void pressAnyKeyToContinue() {
        System.out.println("\nPress Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

    public static void clearScreen() {

    }
}