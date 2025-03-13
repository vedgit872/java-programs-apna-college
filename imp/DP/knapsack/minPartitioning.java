package imp.DP.knapsack;
public class minPartitioning{
    public static int partitioning(int arr[]){
        int n=arr.length;
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        int W=sum/2;
        int dp[][]=new int[n+1][W+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(arr[i-1]<=j){
                    dp[i][j]=Math.max(arr[i-1]+dp[i-1][j-arr[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int sum1=dp[n][W];
        int sum2=sum-sum1;
        return Math.abs(sum1-sum2);
    }
    public static void main(String args[]){
        int arr[]={1,5,6,11};
        System.out.println(partitioning(arr));
    }
}