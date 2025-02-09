package imp.graph;

import java.util.ArrayList;

public class cycledetectiondfs {
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

    public static boolean cycledetection(ArrayList<edge> graph[]) {
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                if (cycledetectionUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cycledetectionUtil(ArrayList<edge> graph[], boolean[] vis, int curr, int parent) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                if (cycledetectionUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            } else if (e.dest != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<edge>[] graph = new ArrayList[v];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new edge(0, 1, 5));
        graph[1].add(new edge(1, 0, 5));
        graph[1].add(new edge(1, 2, 1));
        graph[1].add(new edge(1, 3, 3));
        graph[2].add(new edge(2, 1, 1));
        // graph[2].add(new edge(2, 3, 1));
        graph[2].add(new edge(2, 4, 2));
        // graph[3].add(new edge(3, 2, 1));
        graph[3].add(new edge(3, 1, 3));
        graph[4].add(new edge(4, 2, 2));

        System.out.println(cycledetection(graph)); // Expected Output: true
    }
}
