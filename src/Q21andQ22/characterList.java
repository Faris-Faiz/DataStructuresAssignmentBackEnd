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
    private DoublyLinkedList<String> listchar = new DoublyLinkedList<String>();
    private DoublyLinkedList<characteristics> list = new DoublyLinkedList<characteristics>();
    private SortList<characteristics> CList = new SortList<characteristics>();
    private DoublyLinkedList<characteristics> List2 = new DoublyLinkedList<characteristics>();
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

                System.out.println();
                String height = listchar.remove(0);
                String weight = listchar.remove(0);
                String strength = listchar.remove(0);
                String agility = listchar.remove(0);
                String intel = listchar.remove(0);
                String coor = listchar.remove(0);
                String lead = listchar.remove(0);

                characteristics character = new characteristics(name, height, weight, strength, agility, intel, coor, lead);
                //add the object to the list
                list.add(i, character);
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

    }

    public void sortAbility() {
        while (true) {

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
                switch (attribute) {
                    case "height":
                        for (int k = 0; k < list.size(); k++) {
                            int height = Integer.parseInt(list.show(k).getHeight());
                            CList.addNode(height);
                        }
                        CList.sortList();
                        //CList.display();
                        for (int i = 0; i < list.size(); i++) {
                            for (int j = 0; j < list.size(); j++) {
                                if (CList.show(i) == Integer.parseInt(list.show(j).getHeight())) {
                                    //String printed = "";
                                    //System.out.println(list.show(j));
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

    public void chooseSoldier(){
        System.out.print("Choose a soldier: ");
       soldierChose = sc.nextLine();
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
        StrengthSoldier = Integer.parseInt(listSoldier.show(0).getStrength());
        AgilitySoldier = Integer.parseInt(listSoldier.show(0).getAgility());
        CoorSoldier = Integer.parseInt(listSoldier.show(0).getCoor());
        IntelSoldier = Integer.parseInt(listSoldier.show(0).getIntel());
        sumStrengthAgility = StrengthSoldier + AgilitySoldier;

        System.out.println("");
        System.out.println("Value of " + soldierChose + "'s strength + agility : " + sumStrengthAgility);
    }
}

