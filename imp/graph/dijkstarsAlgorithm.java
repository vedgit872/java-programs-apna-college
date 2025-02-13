package imp.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class dijkstarsAlgorithm {
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
        int node;
        int path;

        pair(int node, int path) {
            this.node = node;
            this.path = path;
        }

        @Override
        public int compareTo(pair p2) {
            return this.path - p2.path;
        }
    }

    public static void dijkstars(ArrayList<edge>[] graph, int src) {
        int path[] = new int[graph.length];
        for (int i = 0; i < path.length; i++) {
            if (i != src) {
                path[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(src, 0));
        while (!pq.isEmpty()) {
            pair p = pq.remove();
            if (!vis[p.node]) {
                vis[p.node] = true;
                for (int i = 0; i < graph[p.node].size(); i++) {
                    edge e = graph[p.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (path[u] != Integer.MAX_VALUE && path[u] + wt < path[v]) {
                        path[v] = path[u] + wt;
                        pq.add(new pair(v, path[v]));
                    }
                }
            }
        }
        for (int i = 0; i < path.length; i++) {
            System.out.println(i+" "+path[i]);
        }
    }
    public static void main(String[] args) {
        int v = 4;
        ArrayList<edge>[] var5 = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            var5[i] = new ArrayList<>();
        }

        // Adding edges for a Directed Acyclic Graph (DAG)
        var5[0].add(new edge(0, 1, 1));
        var5[0].add(new edge(0, 2, 2));
        var5[1].add(new edge(1, 3, 3));
        var5[2].add(new edge(2, 3, 1)); // No cycles

        dijkstars(var5,0);
    }
}
