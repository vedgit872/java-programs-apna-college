package imp.hashing.hashSet;

import java.util.HashSet;

public class countdistincelement {
    public static void main(String[] args) {
        HashSet<Integer> hs=new HashSet<>();
        int arr[]={4,3,6,2,5,7,3,4,2,1};
        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }
        for (int i : hs) {
            System.out.println(i);
        }
        System.out.println();
        System.out.println(hs.size());
    }
    
}
