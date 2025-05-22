package leetcode.stacks;

/*32. Longest Valid Parentheses
Solved
Hard
Topics
Companies
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.

 

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'. */

import java.util.Stack;

public class LongestValidParantheses {
    public int longestValidParentheses(String s) {
        if (s.equals("")) {
            return 0;
        }

        int n = s.length();
        Stack<Integer> index = new Stack<>();
        int max = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                index.push(i);
            } else {
                if (!index.isEmpty()) {
                    index.pop();
                    count += 2;
                    max = Math.max(max, count);
                } else {
                    count = 0;
                }
            }
        }
        if (!index.isEmpty()) {
            count = 0;
            max = 0;
            int prev = n;
            int i = n;
            while (!index.isEmpty()) {
                prev = i;
                i = index.pop();
                count = prev - i - 1;
                max = Math.max(max, count);
            }
            if (i != 0) {
                count = 0;
                index.clear();
                for (int j = 0; j < i; j++) {
                    char ch = s.charAt(j);
                    if (ch == '(') {
                        index.push(j);
                    } else {
                        if (!index.isEmpty()) {
                            index.pop();
                            count += 2;
                            max = Math.max(max, count);
                        } else {
                            count = 0;
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
