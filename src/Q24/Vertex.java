package Q24;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{
    private static int counter =0;
    public int id;

    //Parent in the path
    public Vertex parent = null;
    public List<Edge> neighbors;


    //Evaluation functions
    protected double f = Double.MAX_VALUE;
    protected double g = Double.MAX_VALUE;

    //Heuristic
    public double pointer;



    public Vertex(){}

    public Vertex(double pointer){
        this.pointer=pointer;
        this.id = counter++;
        this.neighbors = new ArrayList<>();
    }
    @Override
    public int compareTo(Vertex o) {
        return Double.compare(this.f,o.f);
    }


    public static class Edge {
        public int weight;
        public Vertex Vertex;

        public Edge(int weight, Vertex Vertex) {
            this.weight = weight;
            this.Vertex = Vertex;
        }


    }

    public void addBranch(int weight,Vertex Vertex){
        Edge newEdge = new Edge(weight,Vertex);
        neighbors.add(newEdge);
    }

    public double calculateHeuristic(Vertex target){
        return this.pointer;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                '}';
    }
}






