package leetcode.math;

/*You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you will build. */

public class ArrangeCoins {
    public int arrangeCoins(int n) {
        int left = 0, right = n;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        long coinsUsed = (long) mid * (mid + 1) / 2;
        
        if (coinsUsed == n) {
            return mid;
        } else if (coinsUsed < n) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return right;
    }
    public static void main(String[] args) {
        
    }
}
