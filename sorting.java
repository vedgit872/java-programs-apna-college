import java.util.*;

public class sorting {
    public static void bubble(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] += arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
                    swap = true;
                }
            }
            if (!swap)
                break;
        }
    }

    public static void selectionas(int arr[]) {
        int min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j])
                    min = j;
            }
            // you can use a extra variable if you feel below condition is unnnecessary
            if (min == i)
                continue;
            arr[min] += arr[i];
            arr[i] = arr[min] - arr[i];
            arr[min] = arr[min] - arr[i];
            print(arr);
            System.out.println();

        }
    }

    public static void selectiondes(int arr[]) {
        int min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] < arr[j])
                    min = j;
            }
            if (min == i)
                continue;
            arr[min] += arr[i];
            arr[i] = arr[min] - arr[i];
            arr[min] = arr[min] - arr[i];
            print(arr);
            System.out.println();

        }
    }

    /// mine wala method
    public static void insertionas(int arr[]) {
        int k;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean check = true;
            k = arr[i + 1];
            for (int j = i; j >= 0; j--) {
                if (k > arr[j]) {
                    arr[j + 1] = k;
                    check = false;
                    break;
                } else {
                    arr[j + 1] = arr[j];
                }
            }
            if (check) {
                arr[0] = k;
            }
            print(arr);
            System.out.println();
        }
    }

    // apna college method
    public static void insertiona(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int k = arr[i];
            int pev = i - 1;
            for (; pev >= 0 && arr[pev] > k; pev--) {
                arr[pev + 1] = arr[pev];
            }
            arr[pev + 1] = k;
            print(arr);
            System.out.println();
        }
    }
    public static void insertiondes(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int k = arr[i];
            int pev = i - 1;
            for (; pev >= 0 && arr[pev] < k; pev--) {
                arr[pev + 1] = arr[pev];
            }
            arr[pev + 1] = k;
            print(arr);
            System.out.println();
        }
    }

    public static void print(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.print("]");
    }

    public static void println(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void println(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void input(int[] arr, Scanner sc) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }
    public static void input(Integer[] arr, Scanner sc) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }
    public static void countingSortase(int a[]) {
        int largest=a[0];
        for (int i = 1; i < a.length; i++) {
            largest=Math.max(largest, a[i]);  
        }
        int new1[]=new int[largest+1];
        for (int i = 0; i < a.length; i++) {
            new1[a[i]]++;
        }
        int j = 0;
        for (int i = 0; i < new1.length; i++) {
            for (;new1[i]!=0; j++) {
                a[j]=i;
                new1[i]--;
            }
        }
        System.out.println();
        
    }
    public static void countingSortdes(int a[]) {
       int largest=a[0];
        for (int i = 1; i < a.length; i++) {
            largest=Math.max(largest, a[i]);  
        }
        int new1[]=new int[largest+1];
        for (int i = 0; i < a.length; i++) {
            new1[a[i]]++;
        }
        int j = 0;
        for (int i = new1.length-1; i>=0; i--) {
            for (;new1[i]!=0; j++) {
                a[j]=i;
                new1[i]--;
            }
        }
        System.out.println();
        
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int a[] = new int[10];
            input(a, sc);
            // bubble(a);
            // System.out.println("Bubble sort is ");
            // selectionas(a);
            // selectiondes(a);
            // insertionas(a);
            // insertiondes(a);
            // insertiona(a);
            // countingSortase(a);
            countingSortdes(a);
            println(a);
            // Integer ab[] = new Integer[10];
            // input(ab, sc);
            // System.out.println("selection sort is ");                               
            // Arrays.sort(ab);//does not return a arrays changes the array passed by us 
            // Arrays.sort(ab,1,5);//does not return a arrays changes the array passed by us 
            // Arrays.sort(ab,1,5,Collections.reverseOrder());//does not return a arrays changes the array passed by us 
            // Arrays.sort(ab,Collections.reverseOrder());//does not return a arrays changes the array passed by us 
            // println(ab);
        }
    }
}
