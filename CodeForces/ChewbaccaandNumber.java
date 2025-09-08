package CodeForces;

import java.util.*;

public class ChewbaccaandNumber {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long y = 0, i = 1, r = x;
        while (x > 0) {
            long k = x % 10;
            if (x == 9) {
                y += 9 * i;
            } else {
                y += ((k < 9 - k) ? k : 9 - k) * i;
            }
            i *= 10;
            x /= 10;
        }
        System.out.println(y);
    }
}
