package imp.stack_problem;

import java.util.*;

public class paranthesis {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();
            Stack<Character> st = new Stack<>();
            char ch;
            for (int i = 0; i < s.length(); i++) {
                ch = s.charAt(i);
                if (ch == '{' || ch == '[' || ch == '(') {
                    st.push(ch);
                } else if (ch == '}' || ch == ']' || ch == ')') {
                    if (st.isEmpty()) {
                        System.out.println("not a valid paranthesis equation");
                        return;
                    }
                    if ((ch == '}' && st.pop() == '{') || (ch == ']' && st.pop() == '[')
                            || (ch == ')' && st.pop() == '(')) {
                        continue;
                    }
                    System.out.println("not a valid paranthesis equation");
                    return;
                }
            }
        }
        System.out.println("a valid paranthesis equation");
    }

}
