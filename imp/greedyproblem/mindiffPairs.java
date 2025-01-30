package imp.greedyproblem;
import java.util.*;
public class mindiffPairs {
    public static void main(String[] args) {
        int a[]={4,1,8,7};
        int b[]={2,3,5,6};
        Arrays.sort(a);
        Arrays.sort(b);
        int minDiff=0;
        for (int i = 0; i < b.length; i++) {
            minDiff=minDiff+Math.abs(a[i]-b[i]);
        }
        System.out.println(minDiff);
    }
    
}
