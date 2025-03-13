package imp.DP;
import java.util.*;

public class minArrayJumps {
    public static int jumps(int arr[]){
        int n=arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        dp[n-1]=0;//dest to dest is 0 jumps
        
        for (int i = n-2; i >=0; i--) {
            int steps=arr[i];
            int min =Integer.MAX_VALUE;
            for (int j = i+1; j <=i+steps && j<n; j++) {
                if (dp[j]!=-1) {
                    min=Math.min(min,dp[j]+1);
                }
            }
            if (min!=Integer.MAX_VALUE) {
                dp[i]=min;
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int arr[]={2,3,1,1,4};
        System.out.println(jumps(arr));
    }
}
/*if (dp[j] != -1): This checks if the position j is reachable from the current position i. The dp array is initialized with -1, indicating that a position hasn't been reached yet. If dp[j] is not -1, it means there's a valid path to position j, and we can consider it when calculating the minimum jumps from position i.

if (min != Integer.MAX_VALUE): After iterating through all possible jumps from position i, this condition verifies if any of those jumps lead to a reachable position. If min remains Integer.MAX_VALUE, it indicates that none of the subsequent positions were reachable, so dp[i] should remain -1. Otherwise, dp[i] is updated to the minimum number of jumps found. */
