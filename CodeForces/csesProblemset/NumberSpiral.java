package CodeForces.csesProblemset;

import java.util.Scanner;

public class NumberSpiral {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Read the number of test cases as int, which is fine.
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            // --- FIX: Read inputs as long ---
            long y = sc.nextLong(); // Changed from int to long
            long x = sc.nextLong(); // Changed from int to long

            long ans = 0;
            if (y > x) {
                if (y % 2 == 0) {
                    ans = y * y - x + 1;
                } else {
                    ans = (y - 1) * (y - 1) + x;
                }
            } else { // x >= y
                if (x % 2 == 1) {
                    ans = x * x - y + 1;
                } else {
                    ans = (x - 1) * (x - 1) + y;
                }
            }
            System.out.println(ans);
        }
    }
}
