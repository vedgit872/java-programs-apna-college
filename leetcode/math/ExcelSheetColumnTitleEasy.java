package leetcode.math;

/*Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

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

Input: columnNumber = 1
Output: "A"
Example 2:

Input: columnNumber = 28
Output: "AB"
Example 3:

Input: columnNumber = 701
Output: "ZY"
 

Constraints:

1 <= columnNumber <= 231 - 1 */

public class ExcelSheetColumnTitleEasy {
    public String convertToTitle(int columnNumber) {
        if (columnNumber == 1) {
            return "A";
        }
        String s = "";
        int pow = 26;
        while (columnNumber > 0) {
            int mod = columnNumber % 26;
            if (mod == 0)
                mod = 26;
            char curr = (char) (64 + mod);
            s = curr + s;
            columnNumber -= mod;
            columnNumber /= pow;
        }
        return s;
    }

    public static void main(String[] args) {

    }
}
