package imp.recursion;

public class printn_to_1 {
    public static void printdec(int n){
        if (n==1) {
            System.out.print(1);
            return;
        }
        System.out.print(n+" ");
        printdec(n-1);
        return;
    }
    public static void printinc(int n){
        if (n==1) {
            System.out.print(1+" ");
            return;
        }
        printinc(n-1);
        System.out.print(n+" ");
        return;
    }
    public static void main(String[] args) {
        // printdec(5);
        printinc(5);
    }
}
