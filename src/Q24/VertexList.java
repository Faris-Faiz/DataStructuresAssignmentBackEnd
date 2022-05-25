package Q24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class VertexList {
    protected PriorityQueue<Vertex> closedList = new PriorityQueue<>();
    protected PriorityQueue<Vertex> openList = new PriorityQueue<>();
    protected PriorityQueue<Vertex> allList = new PriorityQueue<>();


    public VertexList(){}

    /**
     * Algorithm to find shortest path
     * @param start the start of the path
     * @param target the destination of the path
     * @return shortest Vertex to take to get to the destination
     */
    public Vertex aStar(Vertex start,Vertex target) {


        start.f = start.g + start.calculateHeuristic(target);
        openList.add(start);



        while(!openList.isEmpty()){
            Vertex n = openList.peek();
            if(n == target){
                return n;
            }

            for(Vertex.Edge edge : n.neighbors){
                Vertex m = edge.Vertex;
                double totalWeight = n.g + edge.weight;

                if(!openList.contains(m) && !closedList.contains(m)){
                    m.parent = n;
                    m.g = totalWeight;
                    m.f = m.g + m.calculateHeuristic(target);
                    openList.add(m);
                    allList.add(m);

                } else {
                    if(totalWeight < m.g){
                        m.parent = n;
                        m.g = totalWeight;
                        m.f = m.g + m.calculateHeuristic(target);

                        if(closedList.contains(m)){
                            closedList.remove(m);
                            openList.add(m);

                        }
                    }
                }
            }

            openList.remove(n);
            closedList.add(n);


        }
        return null;
    }

    /**
     * Prints the path taken
     * @param target accepts the destination
     */
    public void printPath(Vertex target){
        Vertex n = target;

        if(n==null)
            return;

        List<Integer> ids = new ArrayList<>();

        while(n.parent != null){
            ids.add(n.id);
            n = n.parent;
        }
        ids.add(n.id);
        Collections.reverse(ids);

        for(int id : ids){
            System.out.print(id + "->");
        }
        System.out.println("");
    }





}
