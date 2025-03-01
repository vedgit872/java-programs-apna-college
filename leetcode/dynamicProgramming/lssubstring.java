package leetcode.dynamicProgramming;

public class lssubstring {
    public boolean isSubsequence(String s, String t) {
        int index = 0;
        for (char c : s.toCharArray()) {
            if (t.indexOf(c, index) == -1)
                return false;
            index = t.indexOf(c, index) + 1;
        }

        return true;
    }

    // my approach (not good can be made better above one is good dp not needed no
    // choice option )
    public boolean isSubsequence1(String s, String t) {
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = true;
        }
        return helper(s, t, dp);
    }

    public boolean helper(String s, String t, boolean dp[][]) {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {

    }
}
