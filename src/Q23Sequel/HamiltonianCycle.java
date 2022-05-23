package HamiltonianCycle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author iwana
 */
class Hamiltonian {
    int[] vertices;
    int[][] adjacencyMatrix;
    int[] visited; //list mapping of vertices to mark vertex visited
    int start;// Starting vertex

    //stack used as list to store the path of the Cycle
    Stack<Integer> HamCycle = new Stack<>();

    int NumberofVertices;

    boolean hasCycle = false; // Check if has a Cycle

    Hamiltonian(int start, int[] vertices, int[][] adjacencyMatrix) {
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
    void displayCycle() {
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

class Main23Sequel {
    public static void main(String[] args) {
        //vertices
        int[] vertices = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //adjacency matrix
        int[][] adjacencyMatrix = {{0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0}};

        int start = 0;

        System.out.print("Enter Starting Point: ");
        Scanner input = new Scanner(System.in);
        start = input.nextInt();
        Hamiltonian hamiltonian = new Hamiltonian(start, vertices, adjacencyMatrix);
        hamiltonian.findCycle();

        //if there is no Hamiltonian Cycle
        if (!hamiltonian.hasCycle) {
            System.out.println("No Path Found.");
        }
    }
}
