package CodeForces.csesProblemset;

import java.util.Scanner;

public class Permutations {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 2 || n == 3) {
            System.out.println("No Solution");
            return;
        }
        int i = 0;
        int[] arr = new int[n];
        for (int k = 2; k <= n; k += 2, i++) {
            arr[i] = k;
        }
        for (int k = 1; k <= n; k += 2, i++) {
            arr[i] = k;
        }
        for (int j = 0; j < n; j++) {
            System.out.print(arr[j] + " ");
        }
    }
}
