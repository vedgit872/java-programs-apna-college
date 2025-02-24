package imp.DP.knapsack;

public class target_sum {
    public static boolean tg_s(int num[],int tarsum){
        boolean dp[][]=new boolean[num.length+1][tarsum+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=true; //null set has sum 0 so always true
        }
         // Filling the DP table
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if((num[i-1]<=j && dp[i-1][j-num[i-1]])||dp[i-1][j]){
                    dp[i][j]=true;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[num.length][tarsum];
    }
    public static void main(String[] args) {
        int num[]={4,2,7,1,3};
        int tagsum=10;
        System.out.println(tg_s(num, tagsum));
    }
}
