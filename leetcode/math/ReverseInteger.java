package leetcode.math;

/*Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 

Constraints:

-231 <= x <= 231 - 1 */

public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int neg = 0;
        if (x < 0) {
            neg++;
            x *= -1;
        }
        long rev = 0;
        while (x > 0) {
            rev *= 10;
            rev += x % 10;
            x /= 10;
        }
        if (neg == 1) {
            rev *= -1;
        }
        if (Math.pow(-2, 31) <= rev && rev <= Math.pow(2, 31) - 1) {
            int rev1 = (int) rev;
            return rev1;
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
