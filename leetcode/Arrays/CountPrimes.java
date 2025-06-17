package leetcode.Arrays;

/*Given an integer n, return the number of prime numbers that are strictly less than n.

 

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0
 

Constraints:

0 <= n <= 5 * 106 */

public class CountPrimes {
    public boolean isPrime(int n){
        if(n==1)return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public int countPrimes(int n) {
        if(n<=2)return 0;
        boolean prim[]=new boolean[n];
        int count=0;
        for(int i=2;i<n;i++){
            prim[i]=true;
        }
        for(int i=2;i*i<n;i++){
            if(isPrime(i)){
                for(int j=i+i;j<n;j+=i){
                    prim[j]=false;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(prim[i]){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}
