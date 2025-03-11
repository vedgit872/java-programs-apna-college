package imp.DP.CatalanNumber;

public class mountainRanges {
    public static int NoOfMountains(int n){//n is pair of upstokes and downstokes
          if(n==0|| n==1)
          return 1;
          int dp[]=new int[n+1];
          dp[0]=1;
          dp[1]=1;
          for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                int inside=dp[j];//no of ways to arrange j pair inside a pair of stokes
                int outside=dp[i-j-1];//no of ways to arrange i-j-1 pair outside a pair of stokes
                dp[i]+=inside*outside;
            }
          }
          return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(NoOfMountains(4));
    }

}
