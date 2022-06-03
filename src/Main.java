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


public class Main {

    public static void main(String[] args) {
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
        //q2.3
        map.scoutWall();
        //q2.5
        marleyWord word = new marleyWord();
        //q2.6
        WallofMaria wall = new WallofMaria();







    }
}
