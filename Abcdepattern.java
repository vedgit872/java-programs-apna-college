import java.util.Scanner;

public class Abcdepattern{
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
           int n=sc.nextInt();
           char k='A';
           for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print((char)k);
                k=(char)(k+1);
            }
            System.out.println();
           }
        }
    }
}