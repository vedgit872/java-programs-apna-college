package imp.recursion;

public class tiling_problem {
    public static int tiling(int n){//with 2 tiles
        //base case
        if (n==0 || n==1) {
            return 1;
        }
        return tiling(n-1)+tiling(n-2);//total wasys=after vertical choice +after horizontal choice
    }
    public static int tiling3(int n){//with 3 tiles
        //base case
        if (n==0 || n==1 || n==2) {
            return 1;
        }
        return tiling3(n-1)+tiling3(n-3);//total wasys=after vertical choice +after horizontal choice
    }
    public static void main(String[] args) {
        System.out.println(tiling(4));
        System.out.println(tiling3(4));
    }
}
