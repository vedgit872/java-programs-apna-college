import java.util.Scanner;
public class Incometax{
    public static void main(String[] args) {
        try( Scanner sc =new Scanner(System.in);){
            double income=sc.nextFloat(),tax;
            if(income<=500000 && income>0){
                tax=0;
                System.out.println(tax);
            }
            else if(income>500000 && income<=1000000){
                tax=income*0.2;
                System.out.println(tax);
            }
            else if(income>1000000 ){
                tax=income*0.3;
            System.out.println(tax);
        }
        else{
            System.out.println("invalid income");
        }
    }
     }
}