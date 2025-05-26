package leetcode.Arrays;

/*Given an integer array nums, find the subarray with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
 

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle. */

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int allNeg = 0;
        int m = Integer.MIN_VALUE;
        int temp = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            m = Math.max(m, nums[i]);
            if (nums[i] >= 0)
                allNeg++;
            temp += nums[i];
            if (temp < 0) {
                temp = 0;
            }
            max = Math.max(max, temp);
        }
        if (allNeg == 0) {
            return m;
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
