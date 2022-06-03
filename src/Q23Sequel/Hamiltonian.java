package Q23Sequel;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author iwana
 */
public class Hamiltonian {
    private int[] vertices;
    private int[][] adjacencyMatrix;
    private int[] visited; //list mapping of vertices to mark vertex visited
    private int start;// Starting vertex

    //stack used as list to store the path of the Cycle
    Stack<Integer> HamCycle = new Stack<>();

    int NumberofVertices;

    private boolean hasCycle = false; // Check if has a Cycle

    public boolean isHasCycle() {
        return hasCycle;
    }

    public Hamiltonian(int start, int[] vertices, int[][] adjacencyMatrix) {
        this.start = start;
        this.vertices = vertices;
        this.adjacencyMatrix = adjacencyMatrix;
        this.NumberofVertices = vertices.length;
        this.visited = new int[vertices.length];
    }

    public void findCycle() {
        //add starting vertex to the list
        HamCycle.push(start);

        //start searching the path
        solve(start);
    }

    private void solve(int vertex) {
        //If the vertex is the start vertex and all nodes have been visited and ends with start vertex it is a Cycle
        if (vertex == start && HamCycle.size() == NumberofVertices + 1) {
            hasCycle = true;

            //display the HamCycle
            displayCycle();

            return;
        }

        //iterate through the next vertices
        for (int i = 0; i < NumberofVertices; i++) {
            if (adjacencyMatrix[vertex][i] == 1 && visited[i] == 0) {
                int nxt = i;
                //visit and add vertex to the Cycle
                visited[nxt] = 1;
                HamCycle.push(nxt);

                //Go to the next vertex to find the Cycle
                solve(nxt);

                //Backtrack
                visited[nxt] = 0;

                HamCycle.pop();
            }
        }
    }

    //Method to display the path of the Cycle
    public void displayCycle() {
        //converting vertex index to the name
        List<Integer> names = new ArrayList<>();
        for (int i : HamCycle) {
            names.add(vertices[i]);
        }
        System.out.println("\nPath found!");
        for (int i = 0; i <= vertices.length; i++) {
            if (i == vertices.length) {
                System.out.print(names.get(i) + "\n");
            } else {
                System.out.print(names.get(i) + " --> ");
            }


        }
        System.out.println();
    }
}
