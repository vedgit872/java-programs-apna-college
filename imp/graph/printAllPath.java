package imp.graph;

import java.util.ArrayList;

public class printAllPath {
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
    public static void printPaths(ArrayList<edge>[] graph,int src,int dest,String path){
        if (src==dest) {
            System.out.println(path+dest);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            edge e=graph[src].get(i);
            printPaths(graph, e.dest, dest, path+src);
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
        var5[0].add(new edge(0, 2, 1));
        var5[1].add(new edge(1, 3, 1));
        var5[2].add(new edge(2, 3, 1)); // No cycles

        printPaths(var5,0,3,"");
    }
}
