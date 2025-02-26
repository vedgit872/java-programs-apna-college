package imp.DP.knapsack;

public class rodCutting {
    public static int maxPRodCut(int l[], int val[], int n) {
        int n1=l.length;
        int dp[][] = new int[n1 + 1][n + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (l[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - l[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n1][n];
    }
    public static void main(String[] args) {
        int l[]={1,2,3,4,5,6,7,8};
        int val[]={1,5,8,9,10,17,17,20};
        int n=8;
        System.out.println(maxPRodCut(l, val, n));
    }
}
