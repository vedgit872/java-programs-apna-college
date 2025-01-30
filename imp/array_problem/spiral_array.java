package imp.array_problem;

public class spiral_array {
    public static void spiral_print(int arr[][]){
        int sc=0,ec=arr[0].length-1,sr=0,er=arr.length-1;
        while (sc<=ec && sr<=er) {
            // top
            for (int i = sc; i <= ec; i++) {
                System.err.print(arr[sr][i]+" ");
            }
            // right
            for (int i = sr+1; i <=er; i++) {
                System.err.print(arr[i][ec]+" ");
            }
            // bottom
            for (int i = ec-1; i >=sc; i--) {
                if (sr==er) {
                    return;
                }
                System.err.print(arr[er][i]+" ");
            }
            // left
            for (int i = er-1; i >=sr+1; i--) {
                if (sc==ec) {
                    return;
                }
                System.err.print(arr[i][sr]+" ");   
            }
            sr++;
            er--;
            sc++;
            ec--;
        }
    }
    public static int diagonal_sum(int arr[][]){
        int sum=0;
        for (int i = 0; i <= arr.length-1; i++) {
            sum+=arr[i][i];
            if (i!=arr.length-1-i) {
                sum+=arr[i][arr.length-1-i];
            }
        }
        return sum;

    }
    // top right
    public static boolean staircase(int arr[][],int k){
        int r=0,col=arr[0].length-1;
        while(r<arr.length&&col>=0){
            if(k==arr[r][col]){
                return true;
            }
            else if (k<arr[r][col]) {
                col--;
            }
            else{
                r++;
            }
        
        }
        return false;
    }
    // bottom left
    public static boolean staircase_b_l(int arr[][],int k){
        int r=arr.length-1,col=0;
        while(r>=0&&col<arr.length){
            if(k==arr[r][col]){
                return true;
            }
            else if (k<arr[r][col]) {
                r--;
            }
            else{
                col++;
            }
        
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        spiral_print(arr);
        System.err.println(diagonal_sum(arr));
        System.err.println(staircase(arr,19));
        System.err.println(staircase_b_l(arr,11));
    }
}
