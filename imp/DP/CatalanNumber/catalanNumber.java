package imp.DP.CatalanNumber;

public class catalanNumber {
    public static int recursion(int n){
        if(n==0||n==1){
            return 1;
        }
        int tot=0;
        for (int i = 0; i < n; i++) {
            tot+=recursion(i)*recursion(n-i-1);
        }
        return tot;
    }
    public static int memoization(int n,int []dp){
        if(n==0||n==1){
            return 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int tot=0;
        for (int i = 0; i < n; i++) {
            tot+=memoization(i,dp)*memoization(n-i-1,dp);
        }
        dp[n]=tot;
        return dp[n];
    }
    public static int tabulation(int n){
        if(n==0||n==1){
            return 1;
        }
        int dp[]=new int[n+1];
        dp[0]=dp[1]=1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(recursion(0));
        System.out.println(recursion(1));
        System.out.println(recursion(2));
        System.out.println(recursion(3));
        System.out.println(recursion(4));
        System.out.println(recursion(5));

        System.out.println();
        System.out.println();
        
        int n=0;
        System.out.println(memoization(n, new int[n+1]));
        n=1;
        System.out.println(memoization(n, new int[n+1]));
        n=2;
        System.out.println(memoization(n, new int[n+1]));
        n=3;
        System.out.println(memoization(n, new int[n+1]));
        n=4;
        System.out.println(memoization(n, new int[n+1]));
        n=5;
        System.out.println(memoization(n, new int[n+1]));

        System.out.println();
        System.out.println();

        System.out.println(tabulation(0));
        System.out.println(tabulation(1));
        System.out.println(tabulation(2));
        System.out.println(tabulation(3));
        System.out.println(tabulation(4));
        System.out.println(tabulation(5));
        System.out.println(tabulation(15));
    }
}
