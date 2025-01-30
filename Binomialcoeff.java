import java.util.Scanner;

public class Binomialcoeff {
    public static int binomialCoeff(int n,int r){
        int  nu=1,d=1;
        for(int i=r+1;i<=n;i++){
            nu*=i;
        }
        for(int i=1;i<=n-r;i++){
            d*=i;
        }
        return nu/d;
    }
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
             int n=sc.nextInt();
             int r=sc.nextInt();
             System.out.println(binomialCoeff(n,r));
             
        }
    }
    
}
