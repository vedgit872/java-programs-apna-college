package imp.hashing.hashSet;

import java.util.HashSet;

public class UnionandIntersection {
    public static void main(String[] args) {
        HashSet<Integer> union=new HashSet<>();
        HashSet<Integer> inter=new HashSet<>();
        int arr1[]={7,3};
        int arr2[]={6,3,9,2,9,4};
        for (int i = 0; i < arr1.length; i++) {
            union.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if(union.contains(arr2[i])){
                inter.add(arr2[i]);
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            union.add(arr2[i]);
        }
        System.out.println(union);
        System.out.println(inter);
    }
}

