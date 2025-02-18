package imp.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class mincostWithKStops {
    static class edge {
        int src;
        int dest;
        int cost;

        public edge(int s, int d, int c) {
            this.src = s;
            this.dest = d;
            this.cost = c;
        }
    }

    static class vertex {
        int v;
        int c;
        int stops;

        vertex(int v, int c, int k) {
            this.v = v;
            this.c = c;
            this.stops = k;
        }
    }

    public static void createGraph(int flights[][], ArrayList<edge>[] graph) {
        for (int i = 0; i < flights.length; i++) {
            graph[flights[i][0]].add(new edge(flights[i][0], flights[i][1], flights[i][2]));
        }
    }

    public static int mincostK(int n, int flights[][], int s, int d, int k) {
        ArrayList<edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        createGraph(flights, graph);
        int path[] = new int[n];
        for (int i = 0; i < path.length; i++) {
            if (i != s) {
                path[i] = Integer.MAX_VALUE;
            }
        }
        Queue<vertex> q = new LinkedList<>();
        q.add(new vertex(s, 0, 0));
        while (!q.isEmpty()) {
            vertex curr = q.remove();
            if (curr.stops > k) {
                break;
            }
            for (int i = 0; i < graph[curr.v].size(); i++) {
                edge e = graph[curr.v].get(i);
                if (curr.c + e.cost < path[e.dest] && curr.stops <= k) {
                    path[e.dest] = curr.c + e.cost;
                    q.add(new vertex(e.dest, curr.c + e.cost, curr.stops + 1));
                }
            }

        }
        if (path[d] != Integer.MAX_VALUE) {
            return path[d];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] flights = { { 0, 1, 10 }, { 0, 4, 100 }, { 1, 5, 20 }, { 4, 3, 200 }, { 5, 3, 10 } };
        System.out.println(mincostK(n, flights, 0, 3, 1));
    }
}
