package extraFeature5;


import Q24.Vertex;
import Q24.VertexList;
import Q24.generateMap;

import java.util.Arrays;

public class Main5 {

    public static void main(String[] args) {
        VertexList res = new VertexList();
        generateMap m = new generateMap();

        m.createMap();



        System.out.println(m.getBuildings());
        System.out.println(m.getTree());

//        m.getTitanVertex();


        System.out.println(Arrays.toString(m.getArray()));
        System.out.println();
        //if it is building, if it is tree
        //If coordination < 5 pass building, time = 3, else if coordination < 8, time = 2, else
        //time =1;
        //If intelligence < 5 pass titan, time = 3, else if intelligence < 8, time = 2, else time
        //=1;
        //If agility < 5, pass tree, time = 3, else if agility < 8, time = 2, else time =1;



    }
}
