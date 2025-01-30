import java.util.Scanner;

public class Btod{
    public static int Btd(int a){
        int deci=0,j;
        for(int i=1;a>0;i*=2){
          j=a%10;
          deci+=i*j;
          a/=10;
        }
        return deci;
    }
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
            int a=sc.nextInt();
            System.out.println(Btd(a));
        }
    }
}