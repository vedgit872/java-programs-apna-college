package leetcode.Strings;

/*Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1
 

Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters. */

public class NumberOfSubstringsContainingAllThreeCharachters {
    public int numberOfSubstrings(String s) {
        int[] freq = new int[3];  
        int count = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            freq[s.charAt(end) - 'a']++;
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count += s.length() - end;
                freq[s.charAt(start) - 'a']--;
                start++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}
