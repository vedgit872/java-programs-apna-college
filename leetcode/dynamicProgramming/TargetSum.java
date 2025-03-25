package leetcode.dynamicProgramming;

/*You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

 

Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums)
            sum += num;

        // If (sum + target) is odd or target is out of valid range, return 0
        if ((sum + target) % 2 == 1 || target > sum || target < -sum)
            return 0;

        int subsetSum = (sum + target) / 2;
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1; // Base case: one way to make sum 0 (empty subset)

        // Process each number in the array
        for (int num : nums) {
            for (int j = subsetSum; j >= num; j--) {
                dp[j] += dp[j - num]; // Include current number
            }
        }

        return dp[subsetSum];
    }

    public static void main(String[] args) {

    }
}
