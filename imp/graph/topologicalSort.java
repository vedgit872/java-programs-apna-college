package imp.graph;

import java.util.ArrayList;
import java.util.Stack;

public class topologicalSort {
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

    public static void topsort(ArrayList<edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                topsortutil(graph, i, vis, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }

    public static void topsortutil(ArrayList<edge>[] graph, int curr, boolean[] vis, Stack<Integer> stack) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topsortutil(graph, e.dest, vis, stack);
            }
        }
        stack.push(curr);
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<edge>[] var5 = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            var5[i] = new ArrayList<>();
        }

        // Adding edges for a Directed Acyclic Graph (DAG)
        var5[0].add(new edge(0, 1, 1));
        var5[0].add(new edge(0, 2, 1));
        var5[1].add(new edge(1, 3, 1));
        var5[2].add(new edge(2, 3, 1)); // No cycles

        topsort(var5);
    }
}
