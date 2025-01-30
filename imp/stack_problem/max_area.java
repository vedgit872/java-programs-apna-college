package imp.stack_problem;
import java.util.*;

public class max_area {
    public static int max(int arr[]){
        int max=0,l,r;
        //find smaller left
        int smallerleft[]=new int[arr.length];
        Stack<Integer> s=new Stack<>();
        for (int i = 0; i<arr.length; i++) {
            while (!s.isEmpty() && arr[i]<=arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                smallerleft[i]=-1;
            }
            else{
                smallerleft[i]=s.peek();
            }
            s.push(i);
        }
        // for (int i = 0; i < smallerleft.length; i++) {
        //     System.out.println(smallerleft[i]);
        // }
        //find smaller right
        int smallerright[]=new int[arr.length];
        s.clear();
        for (int i = arr.length-1; i>=0; i--) {
            while (!s.isEmpty() && arr[i]<=arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                smallerright[i]=arr.length;
            }
            else{
                smallerright[i]=s.peek();
            }
            s.push(i);
        }
        //max area 
        for (int i = 0; i < arr.length; i++) {
            r=smallerright[i];
            l=smallerleft[i];
            max=(max>((r-l-1)*arr[i]))?max:(r-l-1)*arr[i];
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[]={3,1,6,6,2,3};
        System.err.println(max(arr));
    }
}
