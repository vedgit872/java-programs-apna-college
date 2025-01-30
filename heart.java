import java.util.Scanner;

public class heart {
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
            int n=sc.nextInt();
            String s=" ++";
            for(int i=1;i<=(n-6);++i){
                s=s+" ";
            }
            s=s+"++";
            System.out.println(s);
            int k=(n-6)/2;
            int m=n/2+1;
            int count=0;
            for(int i=1;i<=(n/2+1);i++){
                for(int j=1;j<=n;j++){
                    if(j==i || j==n+1-i){
                        System.out.print("+");
                    }
                    else if(k>=0 && (j==m-k ||j==m+k) ){
                        System.out.print("+");
                        count++;
                        if(count%2==0 || k==0)  
                        k--;                     
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }

        
    }
}
