package imp.priorityQueues_and_heaps.heapProblem;

import java.util.PriorityQueue;

public class slidingWindowProblem {
    static class pair implements Comparable<pair>{
        int data;
        int idx;
        pair(int data,int idx){
            this.data=data;
            this.idx=idx;
        }
       @Override
       public int compareTo(pair p1){
        return p1.data-this.data;
       }

    }
    public static void main(String[] args) {
        int arr[]={1,3,-1,-3,5,3,6,7};
        int k=3;
        int val[]=new  int[arr.length-k+1];
        PriorityQueue<pair> pq=new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(new pair(arr[i],1));
        }
        val[0]=pq.peek().data;
        for (int i = k; i<arr.length; i++) {
            if(pq.peek().idx<(i-k+1)){
                pq.remove();
            }
            pq.add(new pair(arr[i], i));
            val[i-k+1]=pq.peek().data;
        }
        for (int i = 0; i < val.length; i++) {
            System.out.println(val[i]);
        }
    }

}
