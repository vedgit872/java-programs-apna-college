package imp.DP.LongestCommonSubsequence;

public class editDistance {
    public static int minOperations(String str1,String str2){
        int l1=str1.length();
        int l2=str2.length();
        int dp[][]=new int[l1+1][l2+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i]=i;
        }
        for (int i =1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i-1)==str2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int add=dp[i][j-1]+1;
                    int del=dp[i-1][j]+1;
                    int rep=dp[i-1][j-1]+1;
                    dp[i][j]=Math.min(add,Math.min(del, rep));
                }
            }
        }
        return dp[l1][l2];
    }
    public static void main(String[] args) {
        String str1="intention";
        String str2="execution";
        System.out.println(minOperations(str1, str2));
    }
}
