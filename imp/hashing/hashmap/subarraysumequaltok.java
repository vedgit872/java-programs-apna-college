package imp.hashing.hashmap;

import java.util.HashMap;

public class subarraysumequaltok {
    public static void main(String[] args) {
        int arr[] = {10, 2,-2,-20,10};
        int k = -10;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Case where the sum itself is k
            if (sum == k) {
                count++;
            }

            // If sum-k exists in hashmap, add its frequency to count
            if (hm.containsKey(sum - k)) {
                count += hm.get(sum - k);
            }

            // Store the frequency of the prefix sum
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }

        System.out.println(count);
    }
}
