package imp.priorityQueues_and_heaps.heapProblem;

import java.util.PriorityQueue;

public class nRopes {
    static class ropes implements Comparable<ropes>{
        int l;
        ropes(int l){
            this.l=l;
        }
        @Override
        public int compareTo(ropes r1){
            return this.l-r1.l;
        }
    }
    public static void main(String[] args) {
        int arr[]={4,3,2,6};
        PriorityQueue<ropes> r=new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            r.add(new ropes(arr[i]));
        }
        int sum=0;
        int joined;
        while(r.size()!=1){
            joined=r.remove().l+r.remove().l;
            sum+=joined;
            r.add(new ropes(joined));
        }
        System.out.println(sum);
    }
}
