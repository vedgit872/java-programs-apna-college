package imp.DP.knapsack;

public class zero_one_knapsack {
    public static int zero_1_knapsack(int[] val, int[] wt, int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (wt[n - 1] <= W) {
            int acc = val[n - 1] + zero_1_knapsack(val, wt, W - wt[n - 1], n - 1);
            int rej = zero_1_knapsack(val, wt, W, n - 1);
            return Math.max(acc, rej);
        }
        return zero_1_knapsack(val, wt, W, n - 1);
    }

    public static int zero_1_knapsack_memoization(int[] val, int[] wt, int W, int n, int[][] dp) {
        // Base case: If there are no items or capacity is 0
        if (n == 0 || W == 0) {
            return 0;
        }
    
        // If result is already computed, return it
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
    
        // If the weight of the nth item is less than or equal to W, consider it
        if (wt[n - 1] <= W) {
            // Store the result in dp array
            dp[n][W] = Math.max(
                val[n - 1] + zero_1_knapsack_memoization(val, wt, W - wt[n - 1], n - 1, dp),
                zero_1_knapsack_memoization(val, wt, W, n - 1, dp)
            );
        } else {
            // If weight is more than capacity, skip this item
            dp[n][W] = zero_1_knapsack_memoization(val, wt, W, n - 1, dp);
        }
    
        return dp[n][W];
    }
    public static int zero_1_knapsack_tabulation(int[] val, int[] wt, int W, int n, int[][] dp) {
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1; j++) {
                if(wt[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j-wt[i-1]]+val[i-1],dp[i-1][j]);
                    continue;
                }
                dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        int n = val.length;
        System.out.println(zero_1_knapsack(val, wt, W, n));
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(zero_1_knapsack_memoization(val, wt, W, n, dp));
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = 0;
            }
        }
        System.out.println(zero_1_knapsack_tabulation(val, wt, W, n, dp));
    }
}
