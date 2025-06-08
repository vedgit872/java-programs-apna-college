package leetcode.Strings;

/*Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.
 

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false
 

Constraints:

1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters. */

public class RotateString {
    public String rotate(int i, String s) {
        char[] ch = s.toCharArray();
        int k = 0;
        for (int j = i; j < ch.length; j++, k++) {
            ch[k] = ch[j];
        }
        for (int j = 0; j < i; j++, k++) {
            ch[k] = s.charAt(j);
        }
        return new String(ch);
    }

    public boolean rotateString(String s, String goal) {
        int l1 = s.length(), l2 = s.length();
        if (l1 != l2) {
            return false;
        }
        int i = 0, j = 0;
        while (i < l1 && j < l2) {
            if (s.charAt(i) == goal.charAt(j)) {
                if (rotate(i, s).equals(goal)) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
