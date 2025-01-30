public class Nestedfor {
    public static void main(String []args){
        //star pattern
        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        //inverted star pattern
        for(int i=1;i<=5;i++){
            for(int j=1;j<=6-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        //inverted spacestar pattern
        for(int i=1;i<=5;i++){
            for(int j=1;j<=5;j++){
                if(j>=i){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        //inverted pyramid star pattern
        for(int i=1;i<=3;i++){
            for(int j=1;j<=5;j++){
                if(j>=i&&j<=6-i){
                    System.out.print("*");
                }
                else{
                     System.out.print(" ");
                }
            }
            System.out.println();
        }
        //pyramid star pattern
        for(int i=1;i<=3;i++){
            for(int j=1;j<=5;j++){
                if(j>3-i && j<3+i){
                    System.out.print("*");
                }
                else{
                     System.out.print(" ");
                }
            }
            System.out.println();
        }
        //heart star pattern
        for(int i=1;i<=3;i++){
            for(int j=1;j<=5;j++){
                if(j>3-i && j<3+i){
                    System.out.print("*");
                }
                else{
                     System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
