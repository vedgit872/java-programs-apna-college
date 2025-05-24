package leetcode.Arrays;

/*Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
  */

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Normalize k
        if (k == 0)
            return;
        int[] num = new int[n];
        int i = 0, j = k;
        for (; j < n; j++, i++) {
            num[j] = nums[i];
        }
        j = 0;
        while (j < k) {
            num[j] = nums[i];
            j++;
            i++;
        }
        for (int m = 0; m < n; m++) {
            nums[m] = num[m];
        }
    }

    public static void main(String[] args) {

    }
}
