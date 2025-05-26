package leetcode.Arrays;

/*Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109 */

public class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int pos[] = new int[2];
        pos[0] = -1;
        pos[1] = -1;
        int e = nums.length - 1;
        int s = 0;
        int mid = 0;
        while (s <= e) {
            mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                pos[0] = mid;
                break;
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        if (pos[0] == -1) {
            return pos;
        }
        pos[1] = pos[0];
        while (pos[0] != 0 && nums[pos[0] - 1] == target) {
            pos[0]--;
        }
        while (pos[1] != nums.length - 1 && nums[pos[1] + 1] == target) {
            pos[1]++;
        }
        return pos;
    }

    public static void main(String[] args) {

    }
}
