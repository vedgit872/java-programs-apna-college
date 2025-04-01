package leetcode.math;
/*Lagrange's Four Square Theorem states that:

Every natural number can be expressed as the sum of at most four perfect squares.

In mathematical terms, for any integer 
𝑛≥0 there exist integers 
𝑎,𝑏,𝑐,𝑑
such that:
𝑛=𝑎^2+𝑏^2+𝑐^2+𝑑^2 
where 
a,b,c,d are non-negative integers.

This means that no matter what number you pick, you will never need more than four squares to represent it.  Practical Application in Your Code
Your algorithm determines the minimum number of squares using three main checks:

If n is a perfect square → Return 1 (e.g., 4, 9, 16, 25, ...).

If n % 8 == 7 → Return 4 (e.g., 7, 15, 23, 31, ...).

Check if n can be expressed as a sum of two squares → Return 2 (e.g., 5 = 4 + 1, 13 = 9 + 4).

Otherwise, return 3. */

/*Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

 

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.*/
public class perfectSquare {
    public int numSquares(int n) {
        if (issq(n))
            return 1;
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;
        for (int i = 1; i * i <= n; i++) {
            if (issq(n - i * i))
                return 2;
        }

        return 3;
    }

    public static boolean issq(int x) {
        int s = (int) Math.sqrt(x);
        return s * s == x;
    }

    public static void main(String[] args) {

    }
}
