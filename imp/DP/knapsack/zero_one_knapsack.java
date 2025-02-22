package imp.DP.knapsack;

public class zero_one_knapsack {
    public static int zero_1_knapsack(int []val,int []wt,int W,int n){
        if (n==0||W==0) {
            return 0;
        }
        if (wt[n-1]<=W){
            int acc=val[n-1]+zero_1_knapsack(val, wt, W-wt[n-1], n-1);
            int rej=zero_1_knapsack(val, wt, W, n-1);
            return Math.max(acc, rej);
        }
        return zero_1_knapsack(val, wt, W, n-1);
    }
    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int W=7;
        System.out.println(zero_1_knapsack(val, wt, W, 5));
    }
}
