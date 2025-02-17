package imp.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class primsAlgorithm {
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

    static class pair implements Comparable<pair> {
        int v;
        int cost;

        public pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(pair p2) {
            return this.cost - p2.cost;
        }
    }
    static class pair1 implements Comparable<pair1> {
        int src;
        int dest;
        int cost;

        public pair1(int src,int dest ,int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(pair1 p2) {
            return this.cost - p2.cost;
        }
    }

    public static void prims(ArrayList<edge>[] graph, int src) {
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        int maxwt = 0;
        pq.add(new pair(src, 0));
        while (!pq.isEmpty()) {
            pair ve = pq.remove();
            if (!vis[ve.v]) {
                vis[ve.v] = true;
                maxwt += ve.cost;
                for (int i = 0; i < graph[ve.v].size(); i++) {
                    edge e = graph[ve.v].get(i);
                    pq.add(new pair(e.dest, e.wt));
                }
            }
        }
        System.out.println(maxwt);
    }
    public static void primspath(ArrayList<edge>[] graph, int src) {
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<pair1> pq = new PriorityQueue<>();
        int maxwt = 0;
        pq.add(new pair1(src,src, 0));
        while (!pq.isEmpty()) {
            pair1 ve = pq.remove();
            if (!vis[ve.dest]) {
                vis[ve.dest] = true;
                maxwt += ve.cost;
                System.out.println(ve.src+" "+ve.dest+" "+ve.cost);
                for (int i = 0; i < graph[ve.dest].size(); i++) {
                    edge e = graph[ve.dest].get(i);
                    pq.add(new pair1(e.src,e.dest, e.wt));
                }
            }
        }
        System.out.println(maxwt);
    }
    public static void main(String[] args) {
        int vertices = 5; // Number of vertices in the graph
        ArrayList<edge>[] graph = new ArrayList[vertices];

        // Initialize adjacency list
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges (Undirected Graph)
        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 2, 15);
        addEdge(graph, 0, 3, 30);

        addEdge(graph, 1, 0, 10);
        addEdge(graph, 1, 3, 40);
        
        addEdge(graph, 2, 0, 15);
        addEdge(graph, 2, 3, 50);

        addEdge(graph, 3, 1, 40);
        addEdge(graph, 3, 2, 50);

        // Run Prim's Algorithm from source vertex 0
        System.out.println("Minimum Cost of MST:");
        prims(graph, 0);
        primspath(graph, 0);
    }

    // Helper method to add an edge to the adjacency list
    public static void addEdge(ArrayList<edge>[] graph, int src, int dest, int weight) {
        graph[src].add(new edge(src, dest, weight));
        graph[dest].add(new edge(dest, src, weight)); // Undirected Graph
    }
}
