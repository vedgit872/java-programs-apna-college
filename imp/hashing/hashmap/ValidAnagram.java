package imp.hashing.hashmap;

import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "keen";
        String t = "keen";

        if (s.length() != t.length()) { // Ensure same length
            System.out.println("false");
            return;
        }

        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) - 1);
                if (hm.get(ch) == 0) {
                    hm.remove(ch);
                }
            } else {
                System.out.println("false");
                return; // Stop execution after printing "false"
            }
        }

        System.out.println(hm.isEmpty() ? "true" : "false");
    }
}
