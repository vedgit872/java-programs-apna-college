package imp.DP.fibonnacitype;

public class climbingstairs {
    public static int recStairs(int n){
        if (n==2||n==1) {
            return n;
        }
        return recStairs(n-1)+recStairs(n-2);
    }
    public static int recStairs(int n,int dp[]){
        //memoization
        if (n==2||n==1) {
            return n;
        }
        if (dp[n]!=0) {
            return dp[n];
        }
        dp[n]=recStairs(n-1,dp)+recStairs(n-2,dp);
        return dp[n];
    }
    public static int recStair(int n){
        //tabulation
        if (n == 1) return 1;
        int dp[]=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <=n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static int varrecStairs(int n){
        if (n==2||n==1) {
            return n;
        }
        if(n==3){
            return 4;
        }
        return varrecStairs(n-1)+varrecStairs(n-2)+varrecStairs(n-3);
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Recursion: " + recStairs(n));
        
        int dp[] = new int[n + 1];
        System.out.println("Memoization: " + recStairs(n, dp));
        
        System.out.println("Tabulation: " + recStair(n));
        System.out.println("variation 123: " + varrecStairs(n));
    }
}
