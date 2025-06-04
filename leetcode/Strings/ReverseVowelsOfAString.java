package leetcode.Strings;

/*Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"

 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters. */

public class ReverseVowelsOfAString {
    public boolean isVowel(char c) {
        String ch = (c + "").toLowerCase();
        if (ch.equals("a") || ch.equals("e") || ch.equals("i") || ch.equals("o") || ch.equals("u")) {
            return true;
        } else {
            return false;
        }
    }

    public String reverseVowels(String s) {
        int start = 0, end = s.length() - 1;
        char ch[] = s.toCharArray();
        while (start < end) {
            while (start < end && !isVowel(ch[start])) {
                start++;
            }
            while (start < end && !isVowel(ch[end])) {
                end--;
            }
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        return new String(ch);
    }

    public static void main(String args[]) {

    }
}
