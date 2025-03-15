package leetcode.dynamicProgramming;

public class uniquePaths {
    /*
     * There is a robot on an m x n grid. The robot is initially located at the
     * top-left corner (i.e., grid[0][0]). The robot tries to move to the
     * bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move
     * either down or right at any point in time.
     * 
     * Given the two integers m and n, return the number of possible unique paths
     * that the robot can take to reach the bottom-right corner.
     * 
     * The test cases are generated so that the answer will be less than or equal to
     * 2 * 109.
     */
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[n][m];
        dp[n - 1][m - 1] = 1;// solution to solution is 1
        // dp filling from bottom up ie closer to target then far from target
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (dp[i][j] == 0) {
                    dp[i][j] = (i + 1 < n ? dp[i + 1][j] : 0) + (j + 1 < m ? dp[i][j + 1] : 0);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String args[]) {

    }
}
