package CodeForces.csesProblemset;

import java.util.Scanner;

public class TwoSets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean arr[] = new boolean[n + 1];
        if (n % 4 == 0 || n % 4 == 3) {
            System.out.println("YES");
            int sum = n * (n + 1) / 4;
            int count = 0;
            for (int i = n; sum != 0 && i > 0; i--) {
                if (sum >= i) {
                    sum -= i;
                    arr[i] = true;
                    count++;
                }
            }
            System.out.println(count);
            for (int i = 1; i <= n; i++) {
                if (arr[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            System.out.println(n - count);
            for (int i = 1; i <= n; i++) {
                if (!arr[i]) {
                    System.out.print(i + " ");
                }
            }
        } else {
            System.out.println("No");
        }
    }
}
