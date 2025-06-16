package leetcode.math;

/*The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.

 

Example 1:

Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.
Example 2:

Input: x = 3, y = 1
Output: 1
 

Constraints:

0 <= x, y <= 231 - 1
 

Note: This question is the same as 2220: Minimum Bit Flips to Convert Number. */

public class HammingDistance {
    // here the hamming distance is the number of diffrent bits
    public int hammingDistance(int x, int y) {
        int z=x^y;
        int count=0;
        while(z>0){
            if(z%2==1){
                count++;
            }
            z/=2;
        }
        return count;
    }
    public static void main(String args[]){

    }
}
