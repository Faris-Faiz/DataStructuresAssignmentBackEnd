package Q21andQ22;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Dania
 */
public class characterList {
    Scanner sc = new Scanner(System.in);
    //listchar is to store the splitted string into a list
    private DoublyLinkedList<String> listchar = new DoublyLinkedList<String>();
    //list is to store the characteristics of the characters
    private DoublyLinkedList<characteristics> list = new DoublyLinkedList<characteristics>();
    //CList is to store the characteristics based on highest value for sorting Q2.2
    private SortList<characteristics> CList = new SortList<characteristics>();
    //List2 is to store the CList to make sure the sorted characteristics not printed twice
    private DoublyLinkedList<characteristics> List2 = new DoublyLinkedList<characteristics>();
    //listSoldier is to store the chosen soldier for 2.3
    private DoublyLinkedList<characteristics> listSoldier = new DoublyLinkedList<characteristics>();
    private int StrengthSoldier ;
    private int AgilitySoldier ;
    private int CoorSoldier;
    private int IntelSoldier;
    private int sumStrengthAgility ;
    private String soldierChose;




    public characterList(){}

    public String getSoldierChose() {
        return soldierChose;
    }

    public int getAgilitySoldier() {
        return AgilitySoldier;
    }

    public int getCoorSoldier() {
        return CoorSoldier;
    }

    public int getIntelSoldier() {
        return IntelSoldier;
    }

    public int getStrengthSoldier() {
        return StrengthSoldier;
    }

    public int getSumStrengthAgility() {
        return sumStrengthAgility;
    }




    //to write and read the file based on new characters entered
    public void readFile() throws IOException{

        FileWriter out = new FileWriter("ereh.txt", true);
        PrintWriter outFile = new PrintWriter(out);

//        DoublyLinkedList<String> listchar = new DoublyLinkedList<String>();
        DoublyLinkedList<characteristics> list = new DoublyLinkedList<characteristics>();
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        Scanner sc4 = new Scanner(System.in);
        Scanner sc5 = new Scanner(System.in);
        Scanner sc6 = new Scanner(System.in);
        System.out.println("------Eren's Allies------");
        System.out.println();
        
        while (true) {
            System.out.println();

            System.out.println("Do you want to enter allies?");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("yes")) {
                int i = 0;

                System.out.println();
                System.out.println("Name (name and surname): ");
                String name = sc2.nextLine();

                System.out.println("Enter Characteristics (height, weight, strength, agility, intelligence, coordination, leadership) : ");
                String input1 = sc2.nextLine();
                int i2 = 0;
                
                //to split the characteristics and store into listchar
                
                for (String s : input1.split(" ")) {

                    i2++;
                    listchar.add(i2, s);

                }
                //to remove the listchar based on index and assign to the String Characteristics
                System.out.println();
                String height = listchar.remove(0);
                String weight = listchar.remove(0);
                String strength = listchar.remove(0);
                String agility = listchar.remove(0);
                String intel = listchar.remove(0);
                String coor = listchar.remove(0);
                String lead = listchar.remove(0);

                characteristics character = new characteristics(name, height, weight, strength, agility, intel, coor, lead);
                //add the characteristics to the list
                list.add(i, character);
                //write to the text file to store the characteristics
                outFile.print(name);
                outFile.print(" " + height);
                outFile.print(" " + weight);
                outFile.print(" " + strength);
                outFile.print(" " + agility);
                outFile.print(" " + intel);
                outFile.print(" " + coor);
                outFile.print(" " + lead);
                outFile.println();
                list.clear();
                i++;
                continue;
            }

            outFile.close();
            if (!input.equalsIgnoreCase("yes")) {
                break;
            }

        }

    }
    
    //print out soldiers available
    public void printList() {

        
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
                
                //to split the characteristics and store into listchar
                for (String s : data.split(" ")) {


                    listchar.add(i, s);
                    i++;


                }
                String name = listchar.remove(0) + " " + listchar.remove(0);
                
                //to remove the listchar based on index and assign to the String Characteristics
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

    }
    //to sort the ability of the characters
    public void sortAbility() {
        
         //use switch case to sort abilty
        while (true) {
            
            //clears every list if sorting is looped so it wont print previous 
            List2.clear();
            CList.clear();

            System.out.println();
            System.out.print("Do you want to sort attribute? : ");
            String input1 = sc.nextLine();
            if (input1.equalsIgnoreCase("yes")) {
                System.out.print("\nSorting attribute: ");
                String attribute = sc.nextLine();
                System.out.println();
                System.out.println("Sorting from highest to lowest : \n");
                
                //uses switch case to sort ability based on user input
                switch (attribute) {
                    case "height":
                        for (int k = 0; k < list.size(); k++) {
                            //converts the string in the list for the selected attribute into int and add to CList
                            int height = Integer.parseInt(list.show(k).getHeight());
                            CList.addNode(height);
                        }
                        //sorts the attribute highest value first
                        CList.sortList();
                        //to print out the CList
                        for (int i = 0; i < list.size(); i++) {
                            for (int j = 0; j < list.size(); j++) {
                                
                                if (CList.show(i) == Integer.parseInt(list.show(j).getHeight())) {
                                    //to make sure it wont print the same attribute twice
                                    if (!List2.contains(list.show(j))) {
                                        System.out.println(list.show(j).getName() + " " + CList.show(i));

                                        List2.add(0, list.show(j));
                                    }

                                }


                            }
                        }

                        break;
                    case "weight":
                        for (int k = 0; k < list.size(); k++) {
                            int height = Integer.parseInt(list.show(k).getWeight());
                            CList.addNode(height);
                        }
                        CList.sortList();
                        for (int i = 0; i < list.size(); i++) {
                            for (int j = 0; j < list.size(); j++) {
                                if (CList.show(i) == Integer.parseInt(list.show(j).getWeight())) {
                                    if (!List2.contains(list.show(j))) {
                                        System.out.println(list.show(j).getName() + " " + CList.show(i));
                                        List2.add(0, list.show(j));
                                    }
                                }


                            }
                        }

                        break;
                    case "strength":
                        for (int k = 0; k < list.size(); k++) {
                            int height = Integer.parseInt(list.show(k).getStrength());
                            CList.addNode(height);
                        }
                        CList.sortList();
                        for (int i = 0; i < list.size(); i++) {
                            for (int j = 0; j < list.size(); j++) {
                                if (CList.show(i) == Integer.parseInt(list.show(j).getStrength())) {
                                    if (!List2.contains(list.show(j))) {
                                        System.out.println(list.show(j).getName() + " " + CList.show(i));

                                        List2.add(0, list.show(j));
                                    }

                                }


                            }
                        }

                        break;
                    case "agility":
                        for (int k = 0; k < list.size(); k++) {
                            int height = Integer.parseInt(list.show(k).getAgility());
                            CList.addNode(height);
                        }
                        CList.sortList();
                        for (int i = 0; i < list.size(); i++) {
                            for (int j = 0; j < list.size(); j++) {
                                if (CList.show(i) == Integer.parseInt(list.show(j).getAgility())) {
                                    if (!List2.contains(list.show(j))) {
                                        System.out.println(list.show(j).getName() + " " + CList.show(i));

                                        List2.add(0, list.show(j));
                                    }

                                }


                            }
                        }

                        break;
                    case "intelligence":
                        for (int k = 0; k < list.size(); k++) {
                            int height = Integer.parseInt(list.show(k).getIntel());
                            CList.addNode(height);
                        }
                        CList.sortList();
                        for (int i = 0; i < list.size(); i++) {
                            for (int j = 0; j < list.size(); j++) {
                                if (CList.show(i) == Integer.parseInt(list.show(j).getIntel())) {
                                    if (!List2.contains(list.show(j))) {
                                        System.out.println(list.show(j).getName() + " " + CList.show(i));

                                        List2.add(0, list.show(j));
                                    }

                                }


                            }
                        }

                        break;
                    case "coordination":
                        for (int k = 0; k < list.size(); k++) {
                            int height = Integer.parseInt(list.show(k).getCoor());
                            CList.addNode(height);
                        }
                        CList.sortList();
                        for (int i = 0; i < list.size(); i++) {
                            for (int j = 0; j < list.size(); j++) {
                                if (CList.show(i) == Integer.parseInt(list.show(j).getCoor())) {
                                    if (!List2.contains(list.show(j))) {
                                        System.out.println(list.show(j).getName() + " " + CList.show(i));

                                        List2.add(0, list.show(j));
                                    }

                                }


                            }
                        }

                        break;
                    case "leadership":
                        for (int k = 0; k < list.size(); k++) {
                            int height = Integer.parseInt(list.show(k).getLead());
                            CList.addNode(height);
                        }
                        CList.sortList();
                        for (int i = 0; i < list.size(); i++) {
                            for (int j = 0; j < list.size(); j++) {
                                if (CList.show(i) == Integer.parseInt(list.show(j).getLead())) {
                                    if (!List2.contains(list.show(j))) {
                                        System.out.println(list.show(j).getName() + " " + CList.show(i));

                                        List2.add(0, list.show(j));
                                    }

                                }


                            }
                        }

                        break;
                    default:
                        System.out.print("Attribute not found.");

                }

                continue;
            }
            if (!input1.equalsIgnoreCase("yes")) {
                break;
            }
        }
    }
    //to search ability of characters
    public void searchAbility(){
        while (true) {
            List2.clear();
            System.out.println();
            System.out.print("Do you want to search for ability? : ");
            String input1 = sc.nextLine();
            if (input1.equalsIgnoreCase("yes")) {

                System.out.print("Finding ability : ");
                String ability = sc.nextLine();
                System.out.print("value : ");
                String valueAbility = sc.nextLine();
                System.out.println();

                //use switch case to search for ability and based on its value
                switch (ability) {
                    case "height":
                        System.out.println("soldier : ");
                        for (int i = 0; i < list.size(); i++) {
                            if (list.show(i).getHeight().equalsIgnoreCase(valueAbility)) {
                                System.out.print(list.show(i).getName() + ", ");
                                List2.add(0, list.show(i));
                            }
                        }
                        if (List2.isEmpty())
                            System.out.println("No soldiers found :(");
                        break;
                    case "weight":
                        System.out.println("soldier : ");
                        for (int i = 0; i < list.size(); i++) {
                            if (list.show(i).getWeight().equalsIgnoreCase(valueAbility)) {
                                System.out.print(list.show(i).getName() + ", ");
                                List2.add(0, list.show(i));
                            }
                        }
                        if (List2.isEmpty())
                            System.out.println("No soldiers found :(");
                        break;
                    case "strength":
                        System.out.println("soldier : ");
                        for (int i = 0; i < list.size(); i++) {
                            if (list.show(i).getStrength().equalsIgnoreCase(valueAbility)) {
                                System.out.print(list.show(i).getName() + ", ");
                                List2.add(0, list.show(i));
                            }
                        }
                        if (List2.isEmpty())
                            System.out.println("No soldiers found :(");
                        break;
                    case "agility":
                        System.out.println("soldier : ");
                        for (int i = 0; i < list.size(); i++) {
                            if (list.show(i).getAgility().equalsIgnoreCase(valueAbility)) {
                                System.out.print(list.show(i).getName() + ", ");
                                List2.add(0, list.show(i));
                            }
                        }
                        if (List2.isEmpty())
                            System.out.println("No soldiers found :(");
                        break;
                    case "intelligence":
                        System.out.println("soldier : ");
                        for (int i = 0; i < list.size(); i++) {
                            if (list.show(i).getIntel().equalsIgnoreCase(valueAbility)) {
                                System.out.print(list.show(i).getName() + ", ");
                                List2.add(0, list.show(i));
                            }
                        }
                        if (List2.isEmpty())
                            System.out.println("No soldiers found :(");
                        break;
                    case "coordination":
                        System.out.println("soldier : ");
                        for (int i = 0; i < list.size(); i++) {
                            if (list.show(i).getCoor().equalsIgnoreCase(valueAbility)) {
                                System.out.print(list.show(i).getName() + ", ");
                                List2.add(0, list.show(i));
                            }
                        }
                        if (List2.isEmpty())
                            System.out.println("No soldiers found :(");
                        break;
                    case "leadership":
                        System.out.println("soldier : ");
                        for (int i = 0; i < list.size(); i++) {
                            if (list.show(i).getLead().equalsIgnoreCase(valueAbility)) {
                                System.out.print(list.show(i).getName() + ", ");
                                List2.add(0, list.show(i));
                            }
                        }
                        if (List2.isEmpty())
                            System.out.println("No soldiers found :(");
                        break;
                    default:
                        System.out.print("Ability not found.");
                }
                System.out.println();
                continue;
            }
            if (!input1.equalsIgnoreCase("yes")) {
                break;
            }
        }
    }
    //To choose a soldier for q2.3 and display its strength and agility
    public void chooseSoldier(){
        System.out.print("Choose a soldier: ");
       soldierChose = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            String s = list.show(i).getName();
            if(s.equalsIgnoreCase(soldierChose)){
                //to assign the each character in list as string and add into another listsoldier
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
        //converts the string attribute into int to be calculated
        StrengthSoldier = Integer.parseInt(listSoldier.show(0).getStrength());
        AgilitySoldier = Integer.parseInt(listSoldier.show(0).getAgility());
        CoorSoldier = Integer.parseInt(listSoldier.show(0).getCoor());
        IntelSoldier = Integer.parseInt(listSoldier.show(0).getIntel());
        sumStrengthAgility = StrengthSoldier + AgilitySoldier;

        System.out.println("");
        System.out.println("Value of " + soldierChose + "'s strength + agility : " + sumStrengthAgility);
    }
}



