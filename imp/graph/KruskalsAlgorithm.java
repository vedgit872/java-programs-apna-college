package imp.graph;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalsAlgorithm {
    static class edge implements Comparable<edge> {
        int src;
        int dest;
        int wt;

        public edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(edge e2) {
            return this.wt - e2.wt;
        }
    }

    static int n = 8;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
    }

    public static int find(int n) {
        if (par[n] == n) {
            return n;
        }
        return par[n] = find(par[n]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] > rank[parB]) {
            par[parB] = parA;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        }
    }

    public static void kruskals(ArrayList<edge> edges, int v) {
        init();
        Collections.sort(edges);
        int minCost = 0;
        int count = 0;

        for (int i = 0; i < edges.size() && count < v - 1; i++) { // v vertex connected by v-1 edges in min spannig tree
            edge e = edges.get(i);
            int parA = find(e.src);
            int parB = find(e.dest);

            if (parA != parB) {
                minCost += e.wt;
                union(e.src, e.dest);
                count++;
            }
        }
        System.out.println(minCost);
    }

    public static void main(String[] args) {
        int v = n;
        ArrayList<edge> edges = new ArrayList<>();
        edges.add(new edge(0, 1, 10));
        edges.add(new edge(0, 2, 15));
        edges.add(new edge(0, 3, 30));
        edges.add(new edge(1, 3, 40));
        edges.add(new edge(2, 3, 50));
        kruskals(edges, v);
    }

}
