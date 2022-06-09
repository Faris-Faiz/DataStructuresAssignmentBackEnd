import Q21andQ22.characterList;
import Q24.Map;
import Q25.marleyWord;
import Q26.WallofMaria;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

// This is the GUI version of the Main File
public class MainScreen extends JFrame {
    private JButton option1Button;
    private JButton option2Button;
    private JButton option3Button;
    private JButton option4Button;
    private JPanel panelMain;
    private JLabel labelPic;

    ImageIcon titleImage = new ImageIcon("title.png");
    ImageIcon mapImage = new ImageIcon("map.png");
    ImageIcon wallImage = new ImageIcon("wall.png");
    ImageIcon cipherImage = new ImageIcon("cipher.png");

    public MainScreen() {

        setContentPane(panelMain);
        setTitle("World of Titan");
        setSize(800,800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        labelPic.setText("");
        labelPic.setIcon(titleImage);

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
                labelPic.setIcon(wallImage);
                //q2.6
                WallofMaria wall = new WallofMaria();
                //System.exit(0); // exits the program
            }
        });

        // Hover Mouse
        option1Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                labelPic.setIcon(titleImage);
            }
        });

        option2Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                labelPic.setIcon(mapImage);
            }
        });

        option3Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                labelPic.setIcon(cipherImage);
            }
        });

        option4Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                labelPic.setIcon(wallImage);
            }
        });
    }

    public static void main(String[] args) {
        MainScreen frame = new MainScreen();
    }
}

