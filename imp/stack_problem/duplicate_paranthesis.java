package imp.stack_problem;

import java.util.*;

public class duplicate_paranthesis{
      
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();
            Stack<Character> st = new Stack<>();
            char ch;
            for (int i = 0; i < s.length(); i++) {
                ch = s.charAt(i);
                if (ch == ')') {
                    int count=0;
                    while (st.peek() != '(') {
                        st.pop();
                        count++;
                    }
                    if (count==0) {
                        System.out.println(true+"  repeatable");
                        return;
                    }
                    st.pop();
                }
                else
                st.push(ch);
            }
        }
        System.out.println("a valid without duplicate paranthesis equation");
    }
}
