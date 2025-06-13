package leetcode.Strings;

/*For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

 

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
 

Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English uppercase letters. */

public class GreateastCommonDivisorOfStrings {
     public int GCD(int a,int b){
        if(b==0){
            return a;
        }
        return GCD(b,a%b);
    }
    public String gcdOfStrings(String str1, String str2) {
        int l1=str1.length();
        int l2=str2.length();
        int gcd=GCD((l1>l2)?l1:l2,(l1>l2)?l2:l1);
        for(int i=gcd;i>0;i--){
            if(l1%i==0 && l2%i==0){
                String s=str1.substring(0,i);
                boolean check=true;
                for(int j=0;j<l1 && j<l2;j+=i){
                    if(!(s.equals(str1.substring(j,j+i)) && s.equals(str2.substring(j,j+i)))){
                        check=false;
                    }
                }
                for(int j=l2;j<l1;j+=i){
                    if(!(s.equals(str1.substring(j,j+i)))){
                        check=false;
                    }
                }
                for(int j=l1;j<l2;j+=i){
                    if(!s.equals(str2.substring(j,j+i))){
                        check=false;
                    }
                }
                if(check){
                    return s;
                }
            }
        }
        return "";
    }
    public static void main(String[] args) {
        
    }
}
