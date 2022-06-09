import Q21andQ22.characterList;
import Q24.Map;
import Q25.marleyWord;
import Q26.WallofMaria;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

// This is the GUI version of the Main File
public class MainScreen extends JFrame {
    private JButton option1Button;
    private JButton option2Button;
    private JButton option3Button;
    private JButton option4Button;
    private JPanel panelMain;

    public MainScreen() {

        setContentPane(panelMain);
        setTitle("World of Titan");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        option1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //q2.1
                characterList list = new characterList();
                try {
                    list.readFile();
                } catch (Exception a) {
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
                map.killTitans(list.getSoldierChose(), list.getSumStrengthAgility(), list.getAgilitySoldier(), list.getCoorSoldier());
                //System.exit(0); // exits the program
            }
        });
        option2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //q2.3
                Map map = new Map();
                map.scoutWall();
                //System.exit(0); // exits the program
            }
        });
        option3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //q2.5
                marleyWord word = new marleyWord();
                System.exit(0); // exits the program
            }
        });
        option4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //q2.6
                WallofMaria wall = new WallofMaria();
                //System.exit(0); // exits the program
            }
        });
    }

    public static void main(String[] args) {
        MainScreen frame = new MainScreen();
    }
}

