package CodeForces.csesProblemset;

import java.util.Scanner;

public class MissingNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n - 1];
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        sum = (n * (n + 1) / 2) - sum;
        System.out.println(sum);
    }
}
