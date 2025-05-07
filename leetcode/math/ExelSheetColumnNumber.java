package leetcode.math;

/*Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnTitle = "A"
Output: 1
Example 2:

Input: columnTitle = "AB"
Output: 28
Example 3:

Input: columnTitle = "ZY"
Output: 701
 

Constraints:

1 <= columnTitle.length <= 7
columnTitle consists only of uppercase English letters.
columnTitle is in the range ["A", "FXSHRXW"]. */

public class ExelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int l = columnTitle.length();
        int count = 0;
        for (int i = 1; i < l; i++) {
            count += (int) Math.pow(26, i);
        }
        int extra = 1;
        for (int i = 0; i < l; i++) {
            int c = (int) columnTitle.charAt(i) - 65;
            c *= Math.pow(26, l - i - 1);
            extra += c;
        }
        count += extra;
        return count;
    }

    public static void main(String[] args) {

    }
}
