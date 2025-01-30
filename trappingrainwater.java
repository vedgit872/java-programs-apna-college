import java.util.*;

public class trappingrainwater {
    public static int diffWater(int s, int e, int num[]) {
        System.out.println(s);
        System.out.println(e);
        int min = Math.min(num[s], num[e]);
        int water = 0;
        for (int i = s + 1; i < e; i++) {
            water += (min - num[i]);
        }
        return water;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int num[] = new int[n];
            for (int i = 0; i < num.length; i++) {
                num[i] = sc.nextInt();
            }
            if (n < 3) {
                System.out.println("0");
                return;
            }
            // start of the rain water problem
            int s, e = n - 1;
            for (s = 0; s < num.length - 1; s++) {
                if (num[s] <= num[s + 1])
                    continue;
                else {
                    break;
                }
            }
            for (e = n - 1; e > 0; e--) {
                if (num[e - 1] >= num[e])
                    continue;
                else {
                    break;
                }
            }
            int water = 0, st = s;

            for (int i = s; i <= e; i++) {
                if (num[i] >= num[st] || i == e) {
                    if (st != i) {
                        water += diffWater(st, i, num);
                    }
                    st = i;
                }
            }
            System.out.println("water volume  "+water);
        }

    }
}
