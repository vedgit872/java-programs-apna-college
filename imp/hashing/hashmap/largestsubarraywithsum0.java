package imp.hashing.hashmap;

import java.util.HashMap;

import imp.arrays;

public class largestsubarraywithsum0 {
    public static void main(String[] args) {
        int arr[]={15,-2,2,-8,1,7};
        HashMap<Integer,Integer> hm=new HashMap<>();
        int sum=0;
        int max=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if (hm.containsKey(sum)) {
                max=Math.max(max, i-hm.get(sum));
            }else
            hm.put(sum, i);
        }
        System.out.println(max);
    
    }
}
