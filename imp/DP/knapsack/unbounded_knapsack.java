package imp.DP.knapsack;

public class unbounded_knapsack {
    public static int profit(int val[],int wt[],int W){
        int n=val.length;
        int dp[][]=new int[n+1][W+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (wt[i-1]<=j) {
                    dp[i][j]=Math.max(val[i-1]+dp[i][j-wt[i-1]], dp[i-1][j]);//change here as the  knapsack searches for remaining weight in i items instead of i-1 items like in 01 knapsack
                 }
                 else{
                    dp[i][j]=dp[i-1][j];
                 }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+"   ");
            }
            System.out.println();
        }
        return dp[n][W];
    }
    public static int profit1(int val[], int wt[], int W) {
        int n = val.length;
        int dp[] = new int[W + 1];

        for (int i = 0; i < n; i++) {  // Iterate over items
            for (int j = wt[i]; j <= W; j++) {  // Iterate over weight from item weight to max capacity
                dp[j] = Math.max(dp[j], val[i] + dp[j - wt[i]]);
            }
        }
        
        return dp[W];
    }
    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int W=7;
        System.out.println(profit(val, wt, W));
        System.out.println(profit1(val, wt, W));
    }
}
