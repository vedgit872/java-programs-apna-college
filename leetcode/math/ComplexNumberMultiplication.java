package leetcode.math;

/*A complex number can be represented as a string on the form "real+imaginaryi" where:

real is the real part and is an integer in the range [-100, 100].
imaginary is the imaginary part and is an integer in the range [-100, 100].
i2 == -1.
Given two complex numbers num1 and num2 as strings, return a string of the complex number that represents their multiplications.

 

Example 1:

Input: num1 = "1+1i", num2 = "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:

Input: num1 = "1+-1i", num2 = "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 

Constraints:

num1 and num2 are valid complex numbers. */

public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String num1, String num2) {
        // Parse first complex number
        String[] parts1 = num1.split("\\+");
        int a = Integer.parseInt(parts1[0]);
        int b = Integer.parseInt(parts1[1].replace("i", ""));

        // Parse second complex number
        String[] parts2 = num2.split("\\+");
        int c = Integer.parseInt(parts2[0]);
        int d = Integer.parseInt(parts2[1].replace("i", ""));

        // Compute real and imaginary parts
        int real = a * c - b * d;
        int imaginary = a * d + b * c;

        // Return in the required format
        return real + "+" + imaginary + "i";
        
    }
    public static void main(String[] args) {
        
    }
}
