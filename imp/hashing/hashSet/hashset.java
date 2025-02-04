package imp.hashing.hashSet;

import java.util.*;

public class hashset {
    public static void main(String[] args) {
        HashSet<Integer> hs=new HashSet<>();

        hs.add(1);
        hs.add(2);
        hs.add(4);

        System.out.println(hs);
        
        System.out.println(hs.contains(2));
        System.out.println(hs.contains(5));
        
        hs.remove(2);
        System.out.println(hs);
        
        System.out.println(hs.size());
        System.out.println(hs.isEmpty());
        
        hs.clear();
        System.out.println(hs);
        
        hs.add(1);
        hs.add(2);
        hs.add(4);
        Iterator it=hs.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println();
        
        for (int i:hs) {
            System.out.println(i);            
        }

    }
}
