package imp.DP.LongestCommonSubsequence;

public class WildCardMathching {
    public static boolean match(String s , String p){
        int n=s.length();
        int m=p.length();
        boolean dp[][]=new boolean[n+1][m+1];
        //intialization
        dp[0][0]=true;//the empty string matches the empty pattern
        for (int i = 1; i < dp[0].length; i++) {
            if(p.charAt(i-1)=='*')
            dp[0][i]=dp[0][i-1];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?') {
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];//dp[i][j-1] for * is empty  and other when star is replaced with another sequence of char including this one 
                }
            }
        }
        return dp[n][m];
    } 
    public static void main(String[] args) {
        System.out.println(match("aa", "*b"));
    }
}
