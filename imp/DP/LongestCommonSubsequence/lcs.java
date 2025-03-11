package imp.DP.LongestCommonSubsequence;

public class lcs {
    public static int lcs_recursion(String str1,String str2,int l1, int l2){
        if(l1==0 || l2==0){
            return 0;
        }
        if(str1.charAt(l1-1)==str2.charAt(l2-1)){
            return 1+lcs_recursion(str1, str2, l1-1, l2-1);
        }else{
            return Math.max(lcs_recursion(str1, str2, l1-1, l2),lcs_recursion(str1,str2,l1,l2-1));
        }
    }
    public static int lcs_memoization(String str1,String str2,int l1, int l2,int dp[][]){
        if(l1==0 || l2==0){
            return 0;
        }
        if(dp[l1][l2]!=-1){
            return dp[l1][l2];
        }
        if(str1.charAt(l1-1)==str2.charAt(l2-1)){
            dp[l1][l2]=1+lcs_memoization(str1, str2, l1-1, l2-1,dp);
            return dp[l1][l2];
        }else{
            dp[l1][l2]= Math.max(lcs_memoization(str1, str2, l1-1, l2,dp),lcs_memoization(str1,str2,l1,l2-1,dp));
            return dp[l1][l2];
        }
    }
    public static int lcs_tabulation(String str1,String str2){
        int l1=str1.length();
        int l2=str2.length();
        int dp[][]=new int[l1+1][l2+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i]=0;
        }
        for (int i =1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i-1)==str2.charAt(j-1)) {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[l1][l2];
    }
    public static void main(String[] args) {
        String str1="abcdge";
        String str2="abedg";
        System.out.println(lcs_recursion(str1, str2, str1.length(),str2.length()));
        
        int dp[][]=new int[str1.length()+1][str2.length()+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }
        System.out.println(lcs_memoization(str1, str2, str1.length(),str2.length(),dp));
        
        System.out.println(lcs_tabulation(str1, str2));
    }
}
