package leetcode.math;

/*Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. */

public class RomanToInteger {
    public int romanToInt(String s) {
        int n=s.length();
        int add=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            char prev=(i!=0)?s.charAt(i-1):' ';
            if(ch=='M'){
                 if(prev=='C'){
                   add+=800;
                   continue;
                 }
                 add+=1000;
            }else if(ch=='D'){
                 if(prev=='C'){
                   add+=300;
                   continue;
                 }
                 add+=500;
            }
            else if(ch=='C'){
                 if(prev=='X'){
                   add+=80;
                   continue;
                 }
                 add+=100;
            }else if(ch=='L'){
                 if(prev=='X'){
                   add+=30;
                   continue;
                 }
                 add+=50;
            }else if(ch=='X'){
                 if(prev=='I'){
                   add+=8;
                   continue;
                 }
                 add+=10;
            }else if(ch=='V'){
                 if(prev=='I'){
                   add+=3;
                   continue;
                 }
                 add+=5;
            }else{
                add+=1;
            }
        }
        return add;
    }
    public static void main(String[] args) {
        
    }
}
