package leetcode.Strings;

/*You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

 

Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
Example 2:

Input: s = "azxxzy"
Output: "ay"
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters. */

public class RemoveAllDuplicatesInAString {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int curr = 1;
        int sbl = 1;
        sb.append(s.charAt(0));
        int n = s.length();
        while (curr < n) {
            if (sbl == 0) {
                sb.append(s.charAt(curr));
                sbl++;
            } else if (sb.charAt(sbl - 1) == s.charAt(curr)) {
                sb.deleteCharAt(--sbl);
            } else {
                sb.append(s.charAt(curr));
                sbl++;
            }
            curr++;
        }
        return sb.toString();
    }

    public static void main(String args[]) {

    }
}
