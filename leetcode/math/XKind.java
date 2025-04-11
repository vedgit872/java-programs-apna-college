package leetcode.math;

import java.util.HashMap;
import java.util.Map;

/*You are given an integer array deck where deck[i] represents the number written on the ith card.

Partition the cards into one or more groups such that:

Each group has exactly x cards where x > 1, and
All the cards in one group have the same integer written on them.
Return true if such partition is possible, or false otherwise.

 

Example 1:

Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
Example 2:

Input: deck = [1,1,1,2,2,2,3,3]
Output: false
Explanation: No possible partition. */

public class XKind {
    public static boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) return false;

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : deck) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        int gcd = -1;
        for (int count : countMap.values()) {
            if (gcd == -1)
                gcd = count;
            else
                gcd = getGCD(gcd, count);
        }

        return gcd >= 2;
    }

    // Euclidean algorithm to find GCD
    private static int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }
    public static void main(String[] args) {
        
    }
}
