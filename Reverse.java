import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt(), m = n,sum=0;
            for (int i; n > 0; n = n / 10) {
                i = n % 10;
                if (m == n && i == 0) {
                    i = i / 10;
                    m = m / 10;
                    continue;
                }
                sum=sum*10+i;
                System.out.print(i + "");
            }
            System.out.print("\n"+sum+ "");
        }
    }

}
