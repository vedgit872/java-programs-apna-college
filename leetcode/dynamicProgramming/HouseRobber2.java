package leetcode.dynamicProgramming;

import java.util.Arrays;

/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

 */
public class HouseRobber2 {
    public int rob(int[] nums) {
        int n = nums.length;

        // Handle edge cases
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);

        // Case 1: Rob houses from index 0 to n-2 (ignoring the last house)
        int case1 = robLinear(Arrays.copyOfRange(nums, 0, n - 1));

        // Case 2: Rob houses from index 1 to n-1 (ignoring the first house)
        int case2 = robLinear(Arrays.copyOfRange(nums, 1, n));

        // Return the maximum of both cases
        return Math.max(case1, case2);
    }

    // Helper method to calculate max loot in a linear street (no circular
    // constraint)
    private int robLinear(int[] nums) {
        int prev1 = 0, prev2 = 0;
        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + num);
            prev2 = temp;
        }
        return prev1;
    }

    public static void main(String[] args) {

    }
}
