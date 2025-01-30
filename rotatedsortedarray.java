import java.util.Scanner;

public class rotatedsortedarray {
    public static int rotatedSorted(int[] a, int tar) {
        int e = a.length - 1;
        int s = 0, mid, piv = -1;
    
        // Find pivot
        while (s <= e) {
            mid = s + (e - s) / 2;
            if (mid > 0 && a[mid] < a[mid - 1]) {
                piv = mid;
                break;
            } else if (a[mid] >= a[0]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
    
        // If pivot not found, means array is not rotated
        if (piv == -1) {
            piv = 0;
        }
    
        // Determine which part of the array to search
        if (tar >= a[0] && tar <= a[piv - 1]) {
            return binary(a, 0, piv - 1, tar);
        } else {
            return binary(a, piv, a.length - 1, tar);
        }
    }
    
    public static int binary(int[] a, int s, int e, int target) {
        int mid;
        while (s <= e) {
            mid = s + (e - s) / 2; // Correct way to calculate mid to avoid overflow
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    public static int rotatedSortedmy(int[] a, int tar) {
        int n = a.length;
        int s = 0, e = n - 1;
    
        while (s <= e) {
            int mid = s + (e - s) / 2;
    
            // Direct match
            if (a[mid] == tar) {
                return mid;
            }
    
            // Check if the left half is sorted
            if (a[s] <= a[mid]) {
                // Target is in the left half
                if (a[s] <= tar && tar < a[mid]) {
                    e = mid - 1;
                } else { // Target is in the right half
                    s = mid + 1;
                }
            } else { // Right half is sorted
                // Target is in the right half
                if (a[mid] < tar && tar <= a[e]) {
                    s = mid + 1;
                } else { // Target is in the left half
                    e = mid - 1;
                }
            }
        }
        return -1; // Target not found
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
            int a[] = new int[7];
            input(a, sc);
            print(a);
            int target=sc.nextInt();
            int k=rotatedSorted(a,target);
            System.out.println("index is "+k);
        }
    }
}
