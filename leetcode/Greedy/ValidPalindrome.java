package leetcode.Greedy;

/*Given a string s, return true if the s can be palindrome after deleting at most one character from it.

 

Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters. */

public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                if (validPalindrome1(s.substring(0, i) + s.substring(i + 1))
                        || validPalindrome1(s.substring(0, n - i - 1) + s.substring(n - i))) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validPalindrome1(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}