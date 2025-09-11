package CodeForces.csesProblemset;

import java.util.Scanner;

public class TwoKnights {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for (int i = 1; i <= k; i++) {
            long tot = (long) i * i * (i * i - 1) / 2;
            long attacks = (long) 4 * (i - 1) * (i - 2);//2*3 and 3*2 boards
            System.out.println(tot - attacks);
        }
    }
}
