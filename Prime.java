import java.util.Scanner;

// check till sqrt of that number

public class Prime {
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
            int n=sc.nextInt();
            if (n<2)
            System.out.println("not Prime");
            else{
                if(n==2){
                System.out.println("Prime");
                return;
                }
                n= (int)Math.sqrt(n);
                for(int i=2;i<=n;i++ ){
                    if(n%i==0){
                        System.out.println("not Prime");
                        break;
                    }
                    if(i==n){
                        System.out.println("Prime");
                        break;                        
                    }
                }
            }
        }
    }
}
