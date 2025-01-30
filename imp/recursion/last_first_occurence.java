package imp.recursion;

public class last_first_occurence {
    public static int lo(int[] arr,int i,int n) {
        if (i==-1) {
            return i;
        }
        return (arr[i]==n)?i:lo(arr,i-1,n);
    }
    public static int fo(int[] arr,int i,int n) {
        if (i== arr.length) {
            return -1;
        }
        return (arr[i]==n)?i:fo(arr,i+1,n);
    }
    public static int pow(int x,int n){
        if (n==0) {
            return 1;
        }
        int num=pow(x, n/2);
        if (n%2==0) {
            return num*num;
        }
        else{
            return x*num*num;
        }
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,1,2,3,4,5,6};
        System.out.println(lo(arr, 11, 4));
        System.out.println(fo(arr, 0, 4));
        System.out.println(pow(2, 4));
    }
}
