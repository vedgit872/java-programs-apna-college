// package exersize.module39_trees;

// import java.util.ArrayList;

// public class cycleDetectionUndirectedGraph {
//     static class edge {
//         int src;
//         int dest;
//         int wt;

//         public edge(int s, int d, int w) {
//             this.src = s;
//             this.dest = d;
//             this.wt = w;
//         }
//     }

//     public static boolean cycledetection(ArrayList<edge>[] graph, boolean[] vis, boolean iscycle[], int curr) {
//         if (vis[curr] && iscycle[curr]) {
//             return true;
//         }
//         if (!vis[curr]) {
//             vis[curr] = true;
//             iscycle[curr] = true;
//             for (int i = 0; i < graph[curr].size(); i++) {
//                 if (cycledetection(graph, vis, iscycle, graph[curr].get(i).dest)) {
//                     return true;
//                 }
//             }
//             iscycle[curr] = false;
//         }
//         return false;
//     }

//     public static void main(String[] args) {
//         int v = 5;
//         ArrayList<edge>[] graph = new ArrayList[v];
//         for (int i = 0; i < graph.length; i++) {
//             graph[i] = new ArrayList<>();
//         }

//         graph[0].add(new edge(0, 1, 5));
//         graph[1].add(new edge(1, 0, 5));
//         graph[1].add(new edge(1, 2, 1));
//         graph[1].add(new edge(1, 3, 3));
//         graph[2].add(new edge(2, 1, 1));
//         graph[2].add(new edge(2, 3, 1));
//         graph[2].add(new edge(2, 4, 2));
//         graph[3].add(new edge(3, 2, 1));
//         graph[3].add(new edge(3, 1, 3));
//         graph[4].add(new edge(4, 2, 2));

//         boolean vis[] = new boolean[v];
//         boolean iscycle[] = new boolean[v];

//         System.out.println(cycledetection(graph, vis, iscycle, 0));
//     }
// }

package exersize.module39_trees;

import java.util.ArrayList;

public class cycleDetectionUndirectedGraph {
    static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static boolean cycleDetection(ArrayList<Edge>[] graph, boolean[] vis, int curr, int parent) {
        vis[curr] = true;

        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) { // If the next node is not visited
                if (cycleDetection(graph, vis, e.dest, curr)) {
                    return true;
                }
            } else if (e.dest != parent) { // If visited and not coming from parent, cycle exists
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding undirected edges
        graph[0].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(1, 0, 5));

        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 1, 1));

        graph[1].add(new Edge(1, 3, 3));
        graph[3].add(new Edge(3, 1, 3));

        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 2, 1));

        graph[2].add(new Edge(2, 4, 2));
        graph[4].add(new Edge(4, 2, 2));

        boolean vis[] = new boolean[v];

        // Checking for cycles in all components (useful for disconnected graphs)
        boolean hasCycle = false;
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (cycleDetection(graph, vis, i, -1)) {
                    hasCycle = true;
                    break;
                }
            }
        }

        System.out.println("Cycle present: " + hasCycle);
    }
}
