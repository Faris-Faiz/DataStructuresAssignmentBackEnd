package Q24;
/*https://stackabuse.com/graphs-in-java-a-star-algorithm/*/
import java.util.*;

public class generateMap {
    private Vertex head,n1,n2,n3,n4,n5,n6;
    //map does not include barries
    //maybe make a function that states where the barriers are and generate
    //a map where the barriers are excluded?
    public generateMap(){

    }


    /***
     * PrintsMap with all the Vertexs and branches set already
     */
    public void printMap() {




        //instantiate the head of the graph with 3 branches
        this.head = new Vertex(3);
        //state the origin
        this.head.g = 0;
        //first Vertex with 2 branches
        n1 = new Vertex(2);
        //2nd Vertex with 2 branches
        n2 = new Vertex(2);
        //3rdd Vertex with 2 branches
        n3 = new Vertex(2);

        //from the origin of the map, state the branches and the neighbor
        head.addBranch(1, n1);
        head.addBranch(5, n2);
        head.addBranch(2, n3);
        //at n3, state the branches and the neighbor
        n3.addBranch(1, n2);

        n4 = new Vertex(1);
        n5 = new Vertex(1);
        //create the target destination, it doesnt point to anything
        Vertex n6 = new Vertex(0);

        n1.addBranch(7, n4);
        n2.addBranch(4, n5);
        n3.addBranch(6, n4);

        n4.addBranch(3, n6);
        n5.addBranch(1, n4);
        n5.addBranch(3, n6);
    }

    /**
     * Uses A* algorithm to find the shortest path
     */
    public void findPath(){

        VertexList res = new VertexList();
        res.aStar(head,n6);
        Vertex[] all = new Vertex[res.allList.size()];
        Vertex[] all2 = res.allList.toArray(all);
        //Prints out all the Vertexs
        System.out.println(res.allList.toString());
        Vertex titan = getVertex(all2);
        System.out.print("Location of Titan: " + titan);
        System.out.println();
        res.printPath(titan);



    }

    /**
     * Returns a random Vertex that holds the place of the titan
     * @param array accepts an array of Vertexs
     * @return location of titan
     */
    private static Vertex getVertex(Vertex[] array) {
        Random generator = new Random();
        int rnd = generator.nextInt(array.length);
        return array[rnd];
    }
}
