package imp.hashing.hashmap;

import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        int arr[]={1,3,2,5,1,3,1,5,1};
        HashMap<Integer,Integer> freq=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // if (freq.containsKey(arr[i])) {
            //     freq.put(arr[i], freq.get(arr[i])+1);
            // }
            // else{
            //     freq.put(arr[i],1);
            // }
            // shortcut for above 4 lines
            freq.put(arr[i],freq.getOrDefault(arr[i], 0)+1);
        }
        // Set<Integer> arr1=freq.keySet();
        // for (int i :arr1) {
        //     if (freq.get(i)>arr.length/3) {
        //         System.out.println(i+" appears "+freq.get(i)+" times");
        //     }
        // }
        // shortct for above 4 lines 
        for (int i :freq.keySet()) {
            if (freq.get(i)>arr.length/3) {
                System.out.println(i+" appears "+freq.get(i)+" times");
            }
        }
    }
}
