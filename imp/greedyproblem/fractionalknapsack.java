package imp.greedyproblem;
import java.util.*;

public class fractionalknapsack {
    public static void taken(double it[][],double W){
        double tot=0;
        for (int i = it.length-1; i >=0; i--) {
            if(it[i][2]>W){
                tot=tot+ (W/it[i][2])*it[i][1];
                System.out.println("item"+it[i][0]+" taken in "+W+"KG");
                break;
            }
            else{
                tot=tot+it[i][1];
                W=W-it[i][2];
                System.out.println("item"+it[i][0]+" taken in "+it[i][2]+"KG");
            }
        }
        System.out.println(tot);
    }
    public static void main(String[] args) {
       double weight[]={10,30,20};
       double val[]={60,120,100};
       double W=50;
       double items[][]=new double[weight.length][4];
       for (int i = 0; i < weight.length; i++) {
                 items[i][0]=i;
                 items[i][1]=val[i];
                 items[i][2]=weight[i];
                 items[i][3]=val[i]/weight[i];
       }

       Arrays.sort(items,Comparator.comparingDouble(o->o[3]));
       taken(items,W);
    }
}
