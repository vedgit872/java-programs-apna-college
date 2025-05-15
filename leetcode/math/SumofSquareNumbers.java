package leetcode.math;

/*Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

 

Example 1:

Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:

Input: c = 3
Output: false
 

Constraints:

0 <= c <= 231 - 1
 */

public class SumofSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int sqt = (int) Math.sqrt(c);
        for (int a = 0; a <= sqt; a++) {
            int bsq = c - a * a;
            int b = (int) Math.sqrt(bsq);
            if (b * b == bsq) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
