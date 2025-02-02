package imp.priorityQueues_and_heaps.heapProblem;

import java.util.PriorityQueue;

public class kNearestCar {
    static class distCar implements Comparable<distCar>{
        int dist;
        distCar(int x,int y){
             this.dist=x*x+y*y;
        }
        @Override
        public int compareTo(distCar c2){
            return this.dist-c2.dist;
        }
    }
    public static void main(String[] args) {
        int k=2;
        PriorityQueue<distCar> c=new PriorityQueue<>();
        c.add(new distCar(5, 10));
        c.add(new distCar(5, 11));
        c.add(new distCar(5, 2));
        c.add(new distCar(5, 1));
        for (int i = 0; i < k; i++) {
            System.out.println(c.remove().dist);
        }
    }
}
