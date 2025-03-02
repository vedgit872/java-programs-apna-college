package leetcode.dynamicProgramming;

public class CountingBits {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);// here and is binary addition operator
        }

        return ans;
    }

    /*
     * i >> 1 means divide i by 2 (right shift). It’s the same number, just with the
     * last bit removed.
     * ans[i >> 1] is the number of 1’s in the smaller number.
     * (i & 1) is 1 if the last bit is 1, or 0 if it’s 0.
     * This tells us if i itself contributes 1 more 1.
     */
    public static void main(String[] args) {

    }
}