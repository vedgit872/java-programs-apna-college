package imp.stack_problem;

import java.util.*;

public class stock_span_problem {
    public static void spanStocks(int stocks[],int span[]){
        Stack<Integer> s=new Stack<>();
        span[0]=1;
        s.push(0);
        for (int i = 1; i < stocks.length; i++) {
            while (!s.isEmpty() && stocks[i]>=stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i]=i+1;
            }
            else{
                span[i]=i-s.peek();
            }
            s.push(i);
        }
    }
    public static void main(String[] args) {
        int stocks[]={100,80,60,70,60,85,100};
        // always remember that we have to calculate the number of days in which the current price iis greater than or eqal to price of previous day or days 
        int span[]=new int[stocks.length];
        spanStocks(stocks,span);
        System.out.println();
        for (int i = 0; i < span.length; i++) {
            System.out.println(span[i]);
        }
    }
}
