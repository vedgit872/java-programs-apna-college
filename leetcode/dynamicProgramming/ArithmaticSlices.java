package leetcode.dynamicProgramming;

/*An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
Example 2:

Input: nums = [1]
Output: 0
  */
public class ArithmaticSlices {
    // space of o(n)
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int n = nums.length;
        int dp[] = new int[n - 1];
        int num = 0;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] == 0) {
                if (nums[i] - nums[i - 1] == nums[i + 1] - nums[i]) {
                    dp[i] = 3;
                }
            } else {
                if (nums[i] - nums[i - 1] == nums[i + 1] - nums[i]) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    for (int x = 2; x < dp[i - 1]; x++) {
                        num += dp[i - 1] - x;
                    }
                }
            }
        }
        if (dp[n - 2] >= 3) {
            for (int i = 2; i < dp[n - 2]; i++) {
                num += dp[n - 2] - i;
            }
        }
        return num;
    }

    // a more better solution is in terms of space and time complexity space of O(1)
    public int numberOfArithmeticSlices1(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int n = nums.length;
        int k = 0;
        int num = 0;
        for (int i = 1; i < n - 1; i++) {
            if (k == 0) {
                if (nums[i] - nums[i - 1] == nums[i + 1] - nums[i]) {
                    k = 3;
                }
            } else {
                if (nums[i] - nums[i - 1] == nums[i + 1] - nums[i]) {
                    k++;
                } else {
                    for (int x = 2; x < k; x++) {
                        num += k - x;
                    }
                    k = 0;
                }
            }
        }
        if (k >= 3) {
            for (int i = 2; i < k; i++) {
                num += k - i;
            }
        }
        return num;
    }

    public static void main(String[] args) {

    }
}
