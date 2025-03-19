package leetcode.dynamicProgramming;
/*Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
  */

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i - 1 >= 0) {
                    if (j - 1 >= 0) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    }
                } else {
                    if (j - 1 >= 0) {
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    } else {
                        dp[i][j] = grid[i][j];
                    }
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {

    }
}
