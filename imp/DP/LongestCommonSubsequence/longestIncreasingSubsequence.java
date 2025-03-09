package imp.DP.LongestCommonSubsequence;

import java.util.*;
public class longestIncreasingSubsequence {
    public static int lcs(int arr1[],int arr2[]){
        
        int n=arr1.length;
        int m=arr2.length;

        int dp[][]=new int[n+1][m+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static int lis(int arr[]){
        HashSet<Integer> h=new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            h.add(arr[i]);
        }
        int arr2[]=new int[h.size()];
        int i=0;
        for (int a: h) {
            arr2[i]=a;
            i++;
        }
        Arrays.sort(arr2);//sorting in ascending order
        return lcs(arr,arr2);
    }
    public static void main(String[] args) {
        int arr[]={50,3,10,7,40,80};
        System.out.println(lis(arr));
    }
}
