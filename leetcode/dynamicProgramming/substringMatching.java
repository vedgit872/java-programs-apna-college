package leetcode.dynamicProgramming;

public class substringMatching {
    /*
     * You are given a string s and a pattern string p, where p contains exactly one
     * '*' character.
     * 
     * The '*' in p can be replaced with any sequence of zero or more characters.
     * 
     * Return true if p can be made a substring of s, and false otherwise.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: s = "leetcode", p = "ee*e"
     * 
     * Output: true
     * 
     * Explanation:
     * 
     * By replacing the '*' with "tcod", the substring "eetcode" matches the
     * pattern.
     * 
     * Example 2:
     */
    public boolean hasMatch(String s, String p) {
        int index = p.indexOf('*');
        int firstpos = s.indexOf(p.substring(0, index));
        // finding if the pre * pattern is present in the word , if not its -1
        int secondpos = s.indexOf(p.substring(index + 1), firstpos + index);
        // finding if the post * pattern is present in the word , if not its -1
        if (firstpos != -1 && secondpos != -1) {
            // comparing if both the firstpos and secondpos are not -1 , if not then it
            // means both patterns are present in the word
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
