package leetcode.math;

/*Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

 

Example 1:

Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Example 3:

Input: n = 0
Output: 0
 

Constraints:

0 <= n <= 104 */

public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int k = n;
        int twos = 0;
        int fives = 0;
        while (k > 0) {
            k = k / 2;
            twos += k;
        }
        k = n;
        while (k > 0) {
            k = k / 5;
            fives += k;
        }
        return Math.min(fives, twos);
    }

    public static void main(String[] args) {

    }
}