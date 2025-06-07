package leetcode.Strings;

/*A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters. */

public class ValidPalindrome {
    public boolean alphaNumeric(char ch) {
        int val = (int) ch;
        if (val < 58 && val > 47) {
            return true;
        }
        if (val < 123 && val > 96) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int n = s.length();
        int st = 0;
        int e = n - 1;
        while (st < e) {
            while (!alphaNumeric(s.charAt(st))) {
                st++;
                if (st >= n)
                    break;
            }
            while (!alphaNumeric(s.charAt(e))) {
                e--;
                if (e < 0)
                    break;
            }
            if (e < 0)
                break;
            if (st >= n)
                break;
            if (s.charAt(st) != s.charAt(e)) {
                return false;
            }
            st++;
            e--;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}