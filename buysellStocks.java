import java.util.Scanner;

public class buysellStocks {
    public static int buysell(int arr[]) {
        int buyprice=arr[0];
        int maxp=0;
        int profit;

        for (int i = 0; i < arr.length; i++) {
            if (buyprice<arr[i]) {
                profit=arr[i]-buyprice;
                maxp=Math.max(maxp, profit);
            }
            else{
                buyprice=arr[i];
            }
        }
        return maxp;
    }
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
            int price[]=new int[6];
            for (int i = 0; i < price.length; i++) {
                price[i]=sc.nextInt();
            }
            System.out.println(buysell(price)+" max profit");

            // int p=0;
            // for (int i = 0; i < price.length; i++) {
            //     for (int j = i+1; j < price.length; j++) {
            //         if(p<price[j]-price[i]){
            //             p=price[j]-price[i];
            //         }
            //     }
            // }
            
            // System.out.println(p+" max profit");
        }
    }
}
