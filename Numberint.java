import java.util.Scanner;

public class Numberint {
    public static void main(String[] args) {
        try(Scanner sc =new Scanner(System.in)) {
            long l = sc.nextLong();
            int b = sc.nextInt();
           float perimeter=2*l*b;
            System.out.println(perimeter);
        }
    }
}
