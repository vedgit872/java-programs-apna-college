// isse next greater right 
// isse next greater left 
// next smaller right
// next smaller left
// ye sab solve honge with minimal for loop change for left to right and the while loop greater than equal to less than or equal to for smaller hence an imp for our chapter 



package imp.stack_problem;

import java.util.Stack;

public class next_Greater_Element {
    public static void spanStocks(int num[],int nextGreater[]){
        Stack<Integer> s=new Stack<>();
        for (int i = num.length-1; i>=0; i--) {
            while (!s.isEmpty() && num[i]>=num[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextGreater[i]=-1;
            }
            else{
                nextGreater[i]=num[s.peek()];
            }
            s.push(i);//next  greater not the next greatest farq hai farq hai 
        }
    }
    public static void main(String[] args) {
        int num[]={6,8,0,1,3};
        // always remember that we have to calculate the number of days in which the current price iis greater than or eqal to price of previous day or days 
        int nextGreater[]=new int[num.length];
        spanStocks(num,nextGreater);
        System.out.println();
        for (int i = 0; i < nextGreater.length; i++) {
            System.out.println(nextGreater[i]);
        }
    }
}
