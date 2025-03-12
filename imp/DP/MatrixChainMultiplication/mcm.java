package imp.DP.MatrixChainMultiplication;

public class mcm {
    public static int recursion(int arr[],int i,int j){
        if(i==j){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost1=recursion(arr, i, k);
            int cost2=recursion(arr,k+1,j);
            int cost3=arr[i-1]*arr[k]*arr[j];
            min=Math.min(min,cost1+cost2+cost3);
        }
        return min;
    }
    public static int memoization(int arr[],int i,int j,int dp[][]){
             if(i==j){
                return 0;
             }
             if(dp[i][j]!=-1){
                return dp[i][j];
             }
             int min=Integer.MAX_VALUE;
             for (int k = i; k < j; k++) {
                int cost1=memoization(arr, i, k,dp);
                int cost2=memoization(arr,k+1, j,dp);
                int cost3=arr[i-1]*arr[k]*arr[j];
                min=Math.min(min,cost1+cost2+cost3);
             }
             return dp[i][j]=min;
    }
    public static int tabulation(int arr[]){
        int n=arr.length;
        int dp[][]=new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i==j)
                dp[i][j]=0;
                else
                dp[i][j]=-1;
            }
        }
        for (int len = 2; len < n; len++) {
            for (int i = 1; i <= n-len; i++) {
                int j=i+len-1;//col
                dp[i][j]=Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost1=dp[i][k];
                    int cost2=dp[k+1][j];
                    int cost3=arr[i-1]*arr[k]*arr[j];
                    dp[i][j]=Math.min(dp[i][j],cost1+cost2+cost3);
                }
            }
        }
        return dp[1][n-1];
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,3};
        int n=arr.length;
        System.out.println(recursion(arr, 1, n-1));//i always starts with 1
        int dp[][]=new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }
        System.out.println(memoization(arr, 1, n-1, dp));
        System.out.println(tabulation(arr));
    }
}
