import java.util.Scanner;

public class practiceset12 {

    public static void similar(int[] same) {
        boolean val=false;
            for (int i = 0; i < same.length; i++) {
                for (int j = i+1; j < same.length; j++) {
                    if(same[i]==same[j]){
                         val=true;
                    }
                }
            }
            System.out.println(val);
    }
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
            int same[]=new int[10];
            for (int i = 0; i < same.length; i++) {
                same[i]=sc.nextInt();
            }
            similar(same);
            for (int i = 0; i < same.length; i++) {
                
            }
        }
    }
}
