package imp.DP.CatalanNumber;

public class countingMaxBst {
    public static int count(int n){
        if(n==1||n==0)
        return 1;
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                int left=dp[j];//no of combination of nodes in left subtree
                int rigth=dp[i-j-1];//no of combination of nodes in left subtree
                dp[i]+=left*rigth;//total combinations
            }
        }
        return dp[n];
    }
    public static int count(int arr[]){
        int n=arr.length;
        if(n==1||n==0)
        return 1;
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(count(4));
        int bst[]={1,2,3,4};
        System.out.println(count(bst));
    }
}
