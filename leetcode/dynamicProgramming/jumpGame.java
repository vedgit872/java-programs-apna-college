package leetcode.dynamicProgramming;

public class jumpGame {
    /*
     * You are given an integer array nums. You are initially positioned at the
     * array's first index, and each element in the array represents your maximum
     * jump length at that position.
     * 
     * Return true if you can reach the last index, or false otherwise.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     * 
     * Input: nums = [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum
     * jump length is 0, which makes it impossible to reach the last index.
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean jumps[] = new boolean[n];
        jumps[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = nums[i]; j > 0; j--) {
                if (i + j < n && jumps[i + j]) { // special notice that i+j can be out of bounds
                    jumps[i] = true;
                    break;
                }
            }
        }
        return jumps[0];
    }

    public static void main(String args[]) {

    }
}
