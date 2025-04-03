package leetcode.math;

import java.util.Stack;

/*Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "1 + 1"
Output: 2
Example 2:

Input: s = " 2-1 + 2 "
Output: 3
Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
 

Constraints:

1 <= s.length <= 3 * 105
s consists of digits, '+', '-', '(', ')', and ' '.
s represents a valid expression.
'+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
'-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
There will be no two consecutive operators in the input.
Every number and running calculation will fit in a signed 32-bit integer. */

public class BasicCalculator {
    class Solution {
        public int calculate(String s) {
             Stack<Integer> stack = new Stack<>();
            int num = 0;
            int sign = 1; // 1 for positive, -1 for negative
            int result = 0;
    
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
    
                if (Character.isDigit(ch)) {
                    num = num * 10 + (ch - '0'); 
                } else if (ch == '+' || ch == '-') {
                    result += sign * num; // Apply previous sign
                    num = 0; // Reset number
                    sign = (ch == '+') ? 1 : -1;
                } else if (ch == '(') {
                    stack.push(result);  // Save current result
                    stack.push(sign);    // Save current sign
                    result = 0;          // Reset result for new scope
                    sign = 1;            // Default sign inside brackets
                } else if (ch == ')') {
                    result += sign * num; // Apply last number before ')'
                    num = 0; // Reset number
                    result *= stack.pop(); // Multiply by sign before '('
                    result += stack.pop(); // Add previous result
                }
            }
            return result + (sign * num);
        }
    }
    public static void main(String[] args) {
        
    }
}
