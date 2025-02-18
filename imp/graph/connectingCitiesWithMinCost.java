package imp.graph;

import java.util.PriorityQueue;

public class connectingCitiesWithMinCost {
    static class vertex implements Comparable<vertex>{
        int v;
        int cost;
        vertex(int v,int c){
            this.v=v;
            this.cost=c;
        }
        @Override
        public int compareTo(vertex v2){
            return this.cost-v2.cost;
        }
    }
    public static int minCost(int[][] cities){
         PriorityQueue<vertex> pq=new PriorityQueue<>();
         pq.add(new vertex(0,0));
         boolean vis[]=new boolean[cities.length];
         int cost=0;
         while (!pq.isEmpty()) {
            vertex curr=pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v]=true;
                cost+=curr.cost;
                for (int i = 0; i < cities.length; i++) {
                    if(!vis[i] && cities[curr.v][i]!=0){
                        pq.add(new vertex(i,cities[curr.v][i]));
                    }
                }
            }
         }
         return cost;
    }
    public static void main(String[] args) {
        int[][] cities={{0,1,2,3,4},
                        {1,0,5,0,7},
                        {2,5,0,6,0},
                        {3,0,6,0,0},
                        {4,7,0,0,0}};
        System.out.println(minCost(cities));
    }
}
