package imp.hashing.hashmap;
import java.util.*;
public class linkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> hm=new LinkedHashMap<>();
        hm.put("china", 150);
        hm.put("india", 100);
        hm.put("usa", 50);
        System.out.println(hm);

        // to edit values
        hm.put("china", 120);
        System.out.println(hm);

        // to search a key
        int pop = hm.get("china");
        System.out.println(pop);
        System.out.println(hm.get("bhutan"));

        // to see if a key is present or not
        System.out.println(hm.containsKey("china"));
        System.out.println(hm.containsKey("bhutan"));

        // to remove a element
        System.out.println(hm.remove("china"));
        System.out.println(hm);
        System.out.println(hm.remove("bhutal"));
        System.out.println(hm);

        System.out.println(hm.size());
        System.out.println(hm.isEmpty());
        hm.clear();
        System.out.println(hm);

        hm.put("china", 150);
        hm.put("india", 100);
        hm.put("usa", 50);

        Set<String> s = hm.keySet();
        for (String st : s) {
            System.out.println("key is " + st + ", value is " + hm.get(st));
        }
    }
}
