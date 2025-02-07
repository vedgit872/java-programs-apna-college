package imp.graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

@SuppressWarnings("unchecked")
public class start {
    static class edge{
        int src;
        int dest;
        int wt;
        public edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void bfs(ArrayList<edge>[] graph){
              Queue<Integer> q=new LinkedList<>();
              boolean vis[]=new boolean[graph.length];
              q.add(0);
              while (!q.isEmpty()) {
                int curr=q.remove();
                if (!vis[curr]) {
                    System.out.println(curr+" ");
                    vis[curr]=true;
                    for (int i = 0; i < graph[curr].size(); i++) {
                        q.add(graph[curr].get(i).dest);
                    }
                }
              }
    }
    public static void dfs(ArrayList<edge>[] graph,int curr,boolean vis[]){
        System.out.println(curr+" ");
        vis[curr]=true;

        for (int i = 0; i < graph[curr].size(); i++) {
            edge e =graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }

        }
    }
    public static boolean haspath(ArrayList<edge>[] graph,int curr,int dest,boolean vis[]){
        if (curr==dest) {
            return true;
        }
        vis[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            edge e =graph[curr].get(i);
            if (!vis[e.dest] && haspath(graph, e.dest, dest, vis)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<edge>[] graph=new ArrayList[v];
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new edge(0,1,5));
        
        graph[1].add(new edge(1,0,5));
        graph[1].add(new edge(1,2,1));
        graph[1].add(new edge(1,3,3));
        
        graph[2].add(new edge(2,1,1));
        graph[2].add(new edge(2,3,1));
        graph[2].add(new edge(2,4,2));
        
        graph[3].add(new edge(3,2,1));
        graph[3].add(new edge(3,1,3));
        
        graph[4].add(new edge(4,2,2));

        //neighbours of 2
        // for (int i = 0; i < graph[2].size(); i++) {
        //     System.out.println(graph[2].get(i).dest);
        // }

        // bfs(graph);
        boolean vis[]=new boolean[graph.length];
        // dfs(graph,0,vis);
        System.out.println(haspath(graph, 0, 5, vis));
    }
}
