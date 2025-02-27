package leetcode.stacks;

import java.util.Stack;

public class valid_parantheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        // Map to match closing brackets to their corresponding opening brackets
        java.util.Map<Character, Character> bracketMap = new java.util.HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');

        for (char ch : s.toCharArray()) {
            if (bracketMap.containsKey(ch)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement != bracketMap.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
