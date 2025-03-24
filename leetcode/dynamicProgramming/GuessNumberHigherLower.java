package leetcode.dynamicProgramming;

/*We are playing the Guessing Game. The game will work as follows:

I pick a number between 1 and n.
You guess a number.
If you guess the right number, you win the game.
If you guess the wrong number, then I will tell you whether the number I picked is higher or lower, and you will continue guessing.
Every time you guess a wrong number x, you will pay x dollars. If you run out of money, you lose the game.
Given a particular n, return the minimum amount of money you need to guarantee a win regardless of what number I pick.

 */
public class GuessNumberHigherLower {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];

        // Fill DP table for different lengths of range
        for (int length = 2; length <= n; length++) { // Start with length 2 up to n
            for (int l = 1; l <= n - length + 1; l++) { // Start range from l
                int r = l + length - 1; // End of range
                dp[l][r] = Integer.MAX_VALUE; // Initialize with large value

                // Try every guess x in range [l, r]
                for (int x = l; x < r; x++) {
                    int worstCaseCost = x + Math.max(dp[l][x - 1], dp[x + 1][r]); // Pick worst-case branch
                    dp[l][r] = Math.min(dp[l][r], worstCaseCost); // Choose the minimum worst-case cost
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String args[]) {

    }
}
