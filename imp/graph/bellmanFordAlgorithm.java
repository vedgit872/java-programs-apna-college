package imp.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class bellmanFordAlgorithm {
    static class edge {
        int src;
        int dest;
        int wt;

        public edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void bellmanford(ArrayList<edge>[] graph,int src){
        int[] path=new int[graph.length];
        for (int i = 0; i < path.length; i++) {
            if (i!=src) {
                path[i]=Integer.MAX_VALUE;
            }
        }
        int v=path.length;
        for (int i = 0; i < v-1; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (int j2 = 0; j2 < graph[j].size(); j2++) {
                    edge e=graph[j].get(j2);

                    if (path[e.src]!=Integer.MAX_VALUE && path[e.src]+e.wt<path[e.dest]) {
                        path[e.dest]=path[e.src]+e.wt;
                    }
                }
            }
        }
        for (int i = 0; i < path.length; i++) {
            System.out.println("Distance from " + src + " to " + i + " is " + path[i]);
        }
    }
    public static void bellmanFord(edge[] edges, int v, int src) {
        int[] path = new int[v];

        // Initialize distances
        Arrays.fill(path, Integer.MAX_VALUE);
        path[src] = 0;

        // Relax all edges (V - 1) times
        for (int i = 0; i < v - 1; i++) {
            for (edge e : edges) {
                if (path[e.src] != Integer.MAX_VALUE && path[e.src] + e.wt < path[e.dest]) {
                    path[e.dest] = path[e.src] + e.wt;
                }
            }
        }

        // Check for negative weight cycles
        for (edge e : edges) {
            if (path[e.src] != Integer.MAX_VALUE && path[e.src] + e.wt < path[e.dest]) {
                System.out.println("Graph contains a negative weight cycle!");
                return;
            }
        }

        // Print shortest paths
        for (int i = 0; i < v; i++) {
            System.out.println("Distance from " + src + " to " + i + " is " + (path[i] == Integer.MAX_VALUE ? "∞" : path[i]));
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<edge>[] var5 = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            var5[i] = new ArrayList<>();
        }

        var5[0].add(new edge(0, 1, 2));
        var5[0].add(new edge(0, 2, 4));
        var5[1].add(new edge(1, 2,  -4));
        var5[2].add(new edge(2, 3, 2)); 
        var5[3].add(new edge(3, 4, 4)); 
        var5[4].add(new edge(4, 1,  -1)); 

        bellmanford(var5,0);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        //array implementation
        v = 4; // Number of vertices
        int e = 4; // Number of edges
        edge[] edges = new edge[e];  // Using 'edge' instead of 'Edge'

        // Define edges
        edges[0] = new edge(0, 1, 2);
        edges[1] = new edge(0, 2, 4);
        edges[2] = new edge(1, 2, -4);
        edges[3] = new edge(2, 3, 2);

        bellmanFord(edges, v, 0);
    }
}
