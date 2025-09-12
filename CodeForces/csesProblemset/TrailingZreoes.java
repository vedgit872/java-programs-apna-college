package CodeForces.csesProblemset;

import java.util.Scanner;

public class TrailingZreoes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 0;
        for (int i = 5; i <= n; i *= 5) {
            num += n / i;
        }
        System.out.println(num);
    }
}
