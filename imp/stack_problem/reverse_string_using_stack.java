package imp.stack_problem;

import java.util.*;

public class reverse_string_using_stack {
    public static String reverse(String st){
        Stack<Character> s=new Stack<>();
        int i=0;
        while (st.length()>i) {
            s.push(st.charAt(i));
            i++;
        }
        String k="";//why string builder used  here 
        while (!s.isEmpty()) {
            k=k+s.pop();
        }
        return k;
    }
    public static void main(String[] args) {
        String st="vedant";
        System.out.println(reverse(st));
    }
}
