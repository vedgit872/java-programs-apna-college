package imp.DP.LongestCommonSubsequence;

public class StringConv {
    public static int Convert(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int lcs=dp[n][m];
        int deletions= n-lcs;
        int additions=m-lcs;
        return deletions+additions;

    }
    public static void main(String[] args) {
        System.out.println(Convert("pear", "sea"));
    }
}
