package leetcode.Strings;

/*Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty. */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        int length = (strs[0].length() > strs[1].length()) ? strs[1].length() : strs[0].length();
        for (int i = 0; i < length; i++) {
            if (strs[0].charAt(i) == strs[1].charAt(i)) {
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        if (sb.length() == 0) {
            return "";
        }
        int j = 2;
        while (j < strs.length) {
            length = (sb.length() < strs[j].length()) ? sb.length() : strs[j].length();
            if (length == 0) {
                return "";
            }
            for (int i = 0; i < length; i++) {
                if (strs[j].charAt(i) != sb.charAt(i)) {
                    sb.setLength(0);
                    if (i > 0)
                        sb.append(strs[j].substring(0, i));
                    break;
                }
                if (i == length - 1) {
                    sb.setLength(0);
                    sb.append(strs[j].substring(0, i + 1));
                }
            }
            if (sb.length() == 0) {
                return "";
            }
            j++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
