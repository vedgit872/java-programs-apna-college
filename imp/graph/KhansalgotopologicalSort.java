package imp.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KhansalgotopologicalSort {
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
    public static void calcIndeg(ArrayList<edge>[] graph,int[] in){
           for (int i = 0; i < graph.length; i++) {
               for (int j = 0; j < graph[i].size(); j++) {
                        edge e=graph[i].get(j);
                        in[e.dest]++;
               }
           }
    }
    public static void KhansTopologicalSort(ArrayList<edge>[] graph){
        int[] in=new int[graph.length];
        Queue<Integer> q=new LinkedList<>();

        calcIndeg(graph, in);

        for (int i = 0; i < graph.length; i++) {
            if (in[i]==0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr=q.remove();
            System.out.print(curr+" ");
            for (int i = 0; i < graph[curr].size(); i++) {
                edge e=graph[curr].get(i);
                in[e.dest]--;
                if (in[e.dest]==0) {
                    q.add(e.dest);
                }
                
            }
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

        KhansTopologicalSort(var5);
    }
    
}