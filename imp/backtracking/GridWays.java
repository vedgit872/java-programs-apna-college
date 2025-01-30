package imp.backtracking;

public class GridWays {
    static int count=0;
    public static void ways(int n,int m) {
        //base case
        if(1==n &&1==m){
            count++;
            return;
        }
        if (n-1>=1) {
            ways(n-1, m);            
        }
        if (m-1>=1) {
            ways(n, m-1);
        }
    }
    public static int gridways(int i,int j,int n,int m){
        if (i==n-1 && j==m-1) 
        return 1;
        else if (i==n || j==m) {
            return 0;
        }
        return gridways(i+1, j, n, m)+gridways(i, j+1, n, m); 
    }
    public static void main(String[] args) {
        ways(2, 4);
        System.out.println(count);
        System.out.println(gridways(0, 0, 2, 2));
    }
}
