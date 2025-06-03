package leetcode.Strings;

/*Given a string s, return the number of segments in the string.

A segment is defined to be a contiguous sequence of non-space characters.

 

Example 1:

Input: s = "Hello, my name is John"
Output: 5
Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
Example 2:

Input: s = "Hello"
Output: 1
 

Constraints:

0 <= s.length <= 300
s consists of lowercase and uppercase English letters, digits, or one of the following characters "!@#$%^&*()_+-=',.:".
The only space character in s is ' '. */

public class NumberOfSegmentInStrings {
    public int countSegments(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                continue;
            } else {
                if (count == 0 || s.charAt(i - 1) == ' ') {
                    count++;
                }
                continue;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
