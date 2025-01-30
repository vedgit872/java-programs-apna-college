import java.util.Scanner;

public class rectangle {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int l = sc.nextInt();
            int b = sc.nextInt();
            for (int i = 1; i <= b; i++) {
                for (int j = 1; j <= l; j++) {
                    if ((i > 1 && i < b) && (j > 1 && j < l)) {
                        System.out.print("  ");
                        continue;
                    }
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }

}
