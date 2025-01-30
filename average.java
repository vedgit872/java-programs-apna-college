import java.util.Scanner;

public class average{
    public static void main(String[] args) {
        try(Scanner sc= new Scanner(System.in)){
            int first=sc.nextInt();
            int second=sc.nextInt();
            int third=sc.nextInt();
            int average=(first+second+third)/3;
            int $=100;
            System.out.println(average+$);
        }
    }
}