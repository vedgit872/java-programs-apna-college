package leetcode.Greedy;

import java.util.Arrays;

/*Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.

 

Example 1:

Input: nums = [2,1,2]
Output: 5
Explanation: You can form a triangle with three side lengths: 1, 2, and 2.
Example 2:

Input: nums = [1,2,1,10]
Output: 0
Explanation: 
You cannot use the side lengths 1, 1, and 2 to form a triangle.
You cannot use the side lengths 1, 1, and 10 to form a triangle.
You cannot use the side lengths 1, 2, and 10 to form a triangle.
As we cannot use any three side lengths to form a triangle of non-zero area, we return 0.
 

Constraints:

3 <= nums.length <= 104
1 <= nums[i] <= 106
 */

public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int a = nums[n - 1];
        int b = nums[n - 2];
        int c = nums[n - 3];
        if (a + b > c && a + c > b && b + c > a) {
            return a + b + c;
        } else {
            for (int i = n - 4; i >= 0; i--) {
                a = b;
                b = c;
                c = nums[i];
                if (a + b > c && a + c > b && b + c > a) {
                    return a + b + c;
                }
            }
            return 0;
        }

    }

    public static void main(String[] args) {

    }
}
