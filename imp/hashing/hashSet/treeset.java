package imp.hashing.hashSet;

import java.util.*;

public class treeset {
    public static void main(String[] args) {
        TreeSet<Integer> hs = new TreeSet<>();

        hs.add(0);
        hs.add(2);
        hs.add(4);

        System.out.println(hs); // Output: [0, 2, 4]

        System.out.println(hs.contains(2)); // true
        System.out.println(hs.contains(5)); // false

        hs.remove(2);
        System.out.println(hs); // Output: [0, 4]

        System.out.println(hs.size()); // 2
        System.out.println(hs.isEmpty()); // false

        hs.clear();
        System.out.println(hs); // Output: []

        hs.add(4);
        hs.add(2);
        hs.add(1);

        // Using iterator
        Iterator<Integer> it = hs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println();

        // Using for-each loop
        for (int i : hs) {
            System.out.println(i);
        }
    }
}
