import java.util.Scanner;
public class Dtob {
    public static int Dtb(int in){
        int bin=0,j;
        for(int i=1;in>0;i*=10)
        {
            j=in%2;
            bin+=j*i;
            in/=2;
        }
        return bin;
    }
    
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
            int in=sc.nextInt();
            System.out.println(Dtb(in));
        }
    }
}
