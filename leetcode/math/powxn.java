package leetcode.math;

/*Implement pow(x, n), which calculates x raised to the power n (i.e., xn). O log n Time complexity */

class powxn {
    class Solution {
        public double myPow(double x, int n) {
             long exp = n; // Convert to long to handle Integer.MIN_VALUE case
            if (exp < 0) {
                x = 1 / x; // Handle negative exponent
                exp = -exp;
            }
    
            double result = 1.0;
            while (exp > 0) {
                if (exp % 2 == 1) { // If exponent is odd, multiply x with result
                    result *= x;
                }
                x *= x; // Square the base
                exp /= 2; // Reduce exponent by half
            }
            return result;
        }
    }
    public static void main(String args[]){
        
    }
    
}