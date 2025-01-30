import java.util.Scanner;

public class divideandconquer {
    public static void mergeSort(int A[],int s,int en){//depth first search O(nlogn) -time,, O(n)-space 
        if(s<en){
            int mid=s+(en-s)/2;
            mergeSort(A, s, mid); 
            mergeSort(A, mid+1, en); 
            merge(A,s,mid,en);
        }
    }
    
    public static void merge(int A[], int s, int mid, int e) {
        int temp[] = new int[e - s + 1];
        int i = s, j = mid + 1, k = 0;

        while (i <= mid && j <= e) {
            if (A[i] <= A[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = A[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = A[i++];
        }

        while (j <= e) {
            temp[k++] = A[j++];
        }

        for (i = s, k = 0; i <= e; i++, k++) {
            A[i] = temp[k];
        }
    }

    public static int hoarePartition(int a[], int l, int r) {
        int i = l;      // Left index
        int p = a[l];   // Pivot element
        int j = r + 1;  // Right index
    
        // Partition the array around the pivot
        do {
            do {
                i++;
            } while (i <= r && a[i] < p);
    
            do {
                j--;
            } while (j >= l && a[j] > p);
    
            if (i < j) {
                int temp = a[i]; // Swap elements
                a[i] = a[j];
                a[j] = temp;
            }
        } while (i < j);
    
        int temp = a[l]; // Place pivot in correct position
        a[l] = a[j];
        a[j] = temp;
    
        return j; // Return pivot index
    }
    
    // Function to implement quick sort
    public static void quickSort(int a[], int l, int r) {
        if (l < r) {
            int s = hoarePartition(a, l, r); // Partition the array
            quickSort(a, l, s - 1); // Sort left part
            quickSort(a, s + 1, r); // Sort right part
        }
    }   
    

    public static void print (int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.print("]");
    }
     public static void input(int[] arr, Scanner sc) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int a[] = new int[5];
            input(a, sc);
            // mergeSort(a, 0, a.length-1);
            quickSort(a, 0, a.length-1);
            print(a);
        }
    }

}
