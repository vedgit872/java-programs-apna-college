package imp.greedyproblem;
import java.util.*;
public class IndianCoin {
    public static void main(String[] args) {
        Integer coin[]={1,2,5,10,20,50,100,500,2000};
        int change=1059;
        int ro;
        int count=0;
        Arrays.sort(coin,Comparator.reverseOrder());
        for (int i = 0; i < coin.length; i++) {
            if (coin[i]<=change) {
                ro=change/coin[i];
                System.out.println("Denomination of "+coin[i]+" taken "+ro+" times");
                change-=ro*coin[i];
                count+=ro;
            }
        }
        System.out.println(count);
    }
    
}
