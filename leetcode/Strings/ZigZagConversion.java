package leetcode.Strings;

/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
 

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000*/

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int i = 1;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        while (i <= numRows) {
            int ind = i - 1;
            int stepDownup = 2 * numRows - 2 * i - 1;
            int stepUpdown = 2 * numRows - 2 * (numRows - i + 1) - 1;
            int chance = 1;
            while (ind < n) {
                sb.append(s.charAt(ind));
                if (chance % 2 == 1) {
                    if (stepDownup >= 0) {
                        ind += stepDownup + 1;
                    } else {
                        ind += stepUpdown + 1;
                    }
                } else {
                    if (stepUpdown >= 0) {
                        ind += stepUpdown + 1;
                    } else {
                        ind += stepDownup + 1;
                    }
                }
                chance++;
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
