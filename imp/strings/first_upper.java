package imp.strings;

import java.util.Scanner;

public class first_upper {
    public static String fupper(String s) {
        StringBuilder str=new StringBuilder("");
        str.append(Character.toUpperCase(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            str.append(s.charAt(i));
            if (s.charAt(i)==' ' && i<s.length()-1) 
                str.append(Character.toUpperCase(s.charAt(++i)));
        }
        return str.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(fupper(sc.nextLine()));
    }
}
