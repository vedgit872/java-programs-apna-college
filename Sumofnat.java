import java.util.Scanner;

public class Sumofnat
{
    public static void main(String[] args) {
        try(Scanner sc =new Scanner(System.in)){
            int n=sc.nextInt(), sum =0;
            int i=1;
            while(i<=n){
                sum+=i;
                i++;
            }
            System.out.println(sum);
            for(int j=1;j<=n;j++){
                System.out.println(j);
            }
        }        
    }
}