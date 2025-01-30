package imp;
import java.util.Scanner;

public class arrays {
    public static void sum(int arrays[]) {
        int sum = 0;
        for (int i = 0; i < arrays.length - 1; i++) {
            sum += arrays[i];
        }
        arrays[arrays.length - 1] = sum;
        System.out.println(arrays[arrays.length - 1]);
    }

    public static void print(int arrays[]) {
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + " ");
        }
        System.out.println();
    }
    public static void print(boolean arrays[]) {
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + " ");
        }
        System.out.println();
    }

    public static int input(int arrays[]) {
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < arrays.length; i++) {
                arrays[i] = sc.nextInt();
            }
            int a = sc.nextInt();
            return a;
        }
    }

    public static int linearsearch(int a, int arrays[]) {
        for (int i = 0; i < arrays.length; i++) {
            if (a == arrays[i]) {
                return i;
            }
        }
        return -1;
    }
    // public static int binarysearch(int a,int arrays[]) {
    // int start,end,mid;
    // for (start=0,end=arrays.length-1,mid=(end+1)/2;
    // end>=start;mid=start+(end-start)/2 ) {
    // if (a>arrays[mid]) {
    // start=mid+1;
    // }
    // else{
    // end=mid-1;
    // }
    // }if(end>=mid){
    // return mid;
    // }
    // else
    // return -1;
    // }

    public static int binarySearch(int target, int[] array) {
        int start = 0; // Initialize start index to the beginning of the array
        int end = array.length - 1; // Initialize end index to the last element of the array

        while (start <= end) { // Loop until the search space is exhausted
            int mid = start + (end - start) / 2; // Calculate the mid index to avoid overflow

            if (array[mid] == target) {
                return mid; // Return the index if the target is found
            } else if (array[mid] < target) {
                start = mid + 1; // Adjust start index to narrow the search space to the right half
            } else {
                end = mid - 1; // Adjust end index to narrow the search space to the left half
            }
        }

        return -1; // Return -1 if the target is not found in the array
    }

    public static void reverse(int arrays[]) {
        int start;
        for (start = 0; (arrays.length - 1) / 2 != start; start++) {
            arrays[start] += arrays[arrays.length - 1 - start];
            arrays[(arrays.length - 1) - start] = arrays[start] - arrays[(arrays.length - 1) - start];
            arrays[start] -= arrays[(arrays.length - 1) - start];
        }
    }

    public static int largest(int arrays[]) {
        int largest1 = Integer.MIN_VALUE;
        for (int i = 0; i < arrays.length; i++) {
            if (largest1 < arrays[i]) {
                largest1 = arrays[i];
            }
        }
        return largest1;
    }

    public static boolean[] findsame(int arrays[]) {
        boolean[] same = new boolean[arrays.length];//default value of boolean literal is false 

        for (int i = 0; i < arrays.length; i++) {
            if (same[i])
                continue;

            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[i] == arrays[j]) {
                    same[j] = true;
                }
            }
        }
        return same;

    }
    public static void pairs(int arrays[],boolean same[]) {
        for (int i = 0; i < arrays.length; i++) {
            if (same[i])
                continue;

            for (int j = i + 1; j < arrays.length; j++) {
                if (same[j])
                continue;
               System.out.print("("+arrays[i]+","+arrays[j]+")  ");

            }
        }
    }
    public static int maxsub(int arrays[]) {
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arrays.length; i++) {
            for ( int j = i; j < arrays.length; j++) {
                int sum=0;
                for ( int k= i;k<=j; k++) {
                   sum+=arrays[k];
                }
                if(max<sum)
                max=sum;
            }
        }
        return max;        
    }
    public static int maxsubpre(int arrays[]) {
        int max=Integer.MIN_VALUE,sum;
        int prefix[]=new int[arrays.length];
        prefix[0]=arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            prefix[i]=prefix[i-1]+arrays[i];
        }
        for (int i = 0; i < arrays.length; i++) {
             sum=0;
            for (int j = i; j < arrays.length; j++) {
                sum=(i>0)?prefix[j]-prefix[i-1]:prefix[j];
            }
            if (max<sum) {
                max=sum;
            }
        }
        return max;        
    }
    public static int maxsubKADANES(int arrays[]) {
        int max=Integer.MIN_VALUE;
        int current=0;
        boolean neg=true;
        for (int i = 0; i < arrays.length; i++) {
            neg=arrays[i]>0?false:neg;
            current=current+arrays[i]>=0?current+arrays[i]:0;
            max=current>max?current:max;
        }
        if(neg){
            max=Integer.MIN_VALUE;
            for (int i = 0; i < arrays.length; i++) {
                max=(arrays[i]>max)?arrays[i]:max;
            }
        }
        return max;        
    }
    public static int minsub(int arrays[]) {
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < arrays.length; i++) {
            for ( int j = i; j < arrays.length; j++) {
                int sum=0;
                for ( int k= i;k<=j; k++) {
                   sum+=arrays[k];
                }
                if(min>sum)
                min=sum;
            }
        }
        return min;        
    }

    public static void main(String[] args) {
        int arrays[] = new int[7];
        boolean same[] = new boolean[7];
        // sum(arrays);
        int a = input(arrays);
        // System.out.println(minsub(arrays));
        // System.out.println(maxsubpre(arrays));
        System.out.println(maxsubKADANES(arrays));
        // System.out.println(maxsub(arrays));
        // same=findsame(arrays);
        // print(same);
        // pairs(arrays, same);
        // System.out.println(binarySearch(a,arrays));
        // print(arrays);
        // reverse(arrays);
        // print(arrays);
        // System.out.println(largest(arrays));

    }

}
