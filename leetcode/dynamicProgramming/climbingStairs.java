package leetcode.dynamicProgramming;

public class climbingStairs {
    public int climbStairs(int n) {
        if (n == 1 || n == 2)
            return n;
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
