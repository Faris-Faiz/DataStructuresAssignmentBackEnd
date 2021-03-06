package Q24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class shortestPath {


    private  LinkedList<Integer> path;
    private boolean isBuilding;
    private boolean isTree;
    private int time;

    public int getTime() {
        return time;
    }

    public boolean isBuilding() {
        return isBuilding;
    }

    public boolean isTree() {
        return isTree;
    }

    public shortestPath(){}


    public void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j)
    {
        adj.get(i).add(j);
        adj.get(j).add(i);

    }

    // function to print the shortest distance and path
    // between source vertex and destination vertex
    public void printShortestDistance(
            ArrayList<ArrayList<Integer>> adj,
            int s, int dest, int v, int AgilitySoldier,
            int CoorSoldier,
             int time)
    {
        int pred[] = new int[v];
        int dist[] = new int[v];

        if (BFS(adj, s, dest, v, pred, dist) == false) {
            System.out.println("Given source and destination" +
                    " are not connected");
            return;
        }

        ArrayList<Integer> buildingNodes = new ArrayList<>(Arrays.asList(2,3,4));
        ArrayList<Integer> TreeNodes = new ArrayList<>(Arrays.asList(1,6));


        // LinkedList to store path
        path = new LinkedList<Integer>();
        int crawl = dest;
        path.add(crawl);
        while (pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }


        // Print path
//        If coordination < 5 pass building, time = 3, else if coordination < 8, time = 2, else
//        time =1;
//        If intelligence < 5 pass titan, time = 3, else if intelligence < 8, time = 2, else time
//            =1;
//        If agility < 5, pass tree, time = 3, else if agility < 8, time = 2, else time =1;
        System.out.print("Path is ::");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + "->");
            if(buildingNodes.contains(path.get(i))) {
                if(CoorSoldier < 5) time +=3;
                else if(CoorSoldier <8) time+=2;
                else time+=1;
                System.out.print("(pass Building)");
                isBuilding = true;
                this.time = time;
            }

            else if(TreeNodes.contains(path.get(i))) {
                if(AgilitySoldier < 5) time +=3;
                else if(AgilitySoldier <8) time+=2;
                else time+=1;
                System.out.print("(pass Tree)");
                isTree = true;
                this.time = time;
            }

        }
    }



    private  boolean BFS(ArrayList<ArrayList<Integer>> adj, int src,
                               int dest, int v, int pred[], int dist[])
    {
        // a queue to maintain queue of vertices whose
        // adjacency list is to be scanned as per normal
        // BFS algorithm using LinkedList of Integer type
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // boolean array visited[] which stores the
        // information whether ith vertex is reached
        // at least once in the Breadth first search
        boolean visited[] = new boolean[v];

        // initially all vertices are unvisited
        // so v[i] for all i is false
        // and as no path is yet constructed
        // dist[i] for all i set to infinity
        for (int i = 0; i < v; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }
        visited[src] = true;
        dist[src] = 0;
        queue.add(src);

        // bfs Algorithm
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int i = 0; i < adj.get(u).size(); i++) {
                if (visited[adj.get(u).get(i)] == false) {
                    visited[adj.get(u).get(i)] = true;
                    dist[adj.get(u).get(i)] = dist[u] + 1;
                    pred[adj.get(u).get(i)] = u;
                    queue.add(adj.get(u).get(i));

                    // stopping condition (when we find
                    // our destination)
                    if (adj.get(u).get(i) == dest)
                        return true;
                }
            }
        }
        return false;
    }



    }
