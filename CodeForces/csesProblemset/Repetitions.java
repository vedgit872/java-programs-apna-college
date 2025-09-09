package CodeForces.csesProblemset;

import java.util.Scanner;

public class Repetitions {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int max = 0;
        int temp = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                temp++;
            } else {
                max = Math.max(temp, max);
                temp = 1;
            }
        }
        max = Math.max(temp, max);
        System.out.println(max);
    }
}
