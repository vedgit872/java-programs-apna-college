package imp.graph;
import java.util.ArrayList;

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
        for (int i = 0; i < graph[2].size(); i++) {
            System.out.println(graph[2].get(i).dest);
        }
    }
}
