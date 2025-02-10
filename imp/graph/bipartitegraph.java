package imp.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bipartitegraph {
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
    public static boolean isBipartite (ArrayList<edge>[] graph){
         int col[]=new int[graph.length];
         for (int i = 0; i < col.length; i++) {
            col[i]=-1;
         }

         Queue<Integer> q=new LinkedList<>();
         for (int i = 0; i < graph.length; i++) {
            if (col[i]==-1) {
                q.add(i);
                col[i]=0;
                while (!q.isEmpty()) {
                    int curr=q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        edge e=graph[curr].get(j);
                        if (col[e.dest]==-1) {
                            int nextcolor=col[curr]==0?1:0;
                            col[e.dest]=nextcolor;
                            q.add(e.dest);
                        }
                        else if(col[e.dest]==col[curr]){
                            return false;
                        }                      
                    }
                }
            }
         }
         return true;

    }
    public static void main(String args[]){
        int v1 = 4; // Bipartite cyclic graph (Even cycle)
        int v2 = 5; // Non-bipartite cyclic graph (Odd cycle)

        // Bipartite Graph (4-cycle)
        ArrayList<edge>[] graph1 = new ArrayList[v1];
        for (int i = 0; i < v1; i++) {
            graph1[i] = new ArrayList<>();
        }
        graph1[0].add(new edge(0, 1, 1));
        graph1[1].add(new edge(1, 2, 1));
        graph1[2].add(new edge(2, 3, 1));
        graph1[3].add(new edge(3, 0, 1));

        // Non-Bipartite Graph (5-cycle)
        ArrayList<edge>[] graph2 = new ArrayList[v2];
        for (int i = 0; i < v2; i++) {
            graph2[i] = new ArrayList<>();
        }
        graph2[0].add(new edge(0, 1, 1));
        graph2[1].add(new edge(1, 2, 1));
        graph2[2].add(new edge(2, 3, 1));
        graph2[3].add(new edge(3, 4, 1));
        graph2[4].add(new edge(4, 0, 1));

        System.out.println("Graph1 is bipartite (Even cycle)");
        System.out.println(isBipartite(graph1));
        System.out.println("Graph2 is not bipartite (Odd cycle)");
        System.out.println(isBipartite(graph2));
    }
}
