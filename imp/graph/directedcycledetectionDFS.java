package imp.graph;

import java.util.ArrayList;

public class directedcycledetectionDFS {
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

    public static boolean iscycle(ArrayList<edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];// to check the cycle

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (iscycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean iscycleUtil(ArrayList<edge>[] graph, int curr, boolean[] vis, boolean[] stack) {
        vis[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            if (stack[e.dest]) {
                return true;
            } else if (!vis[e.dest] && iscycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<edge>[] var3 = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            var3[i] = new ArrayList<>();
        }

        // Adding edges for cyclic graph
        var3[0].add(new edge(0, 1, 1));
        var3[1].add(new edge(1, 2, 1));
        var3[2].add(new edge(2, 3, 1));
        var3[3].add(new edge(3, 0, 1));  // Cycle here
        v = 4;
        ArrayList<edge>[] var4 = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            var4[i] = new ArrayList<>();
        }

        // Adding edges for acyclic graph
        var4[0].add(new edge(0, 1, 1));
        var4[1].add(new edge(1, 2, 1));
        var4[2].add(new edge(2, 3, 1));  // No cycle

        System.out.println("graph one is cyclic");
        System.out.println(iscycle(var3));
        System.out.println("graph two is a-cyclic");
        System.out.println(iscycle(var4));

    }
}
