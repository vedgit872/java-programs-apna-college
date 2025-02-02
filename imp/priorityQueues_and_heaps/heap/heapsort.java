package imp.priorityQueues_and_heaps.heap;

public class heapsort {
    public static void heapify(int arr[],int n,int i){
          int max=i;
          int left=i*2+1;
          int right=i*2+2;
          if(left<n && arr[left]>arr[max]){
            max=left;
          }
          if(right<n && arr[right]>arr[max]){
            max=right;
          }
          if (max!=i) {
            int temp=arr[max];
            arr[max]=arr[i];
            arr[i]=temp;
            heapify(arr, n,max);
          }
          
    }

    public static void heapsortmax(int arr[]){
           int n=arr.length;
           for (int i = n/2; i >=0; i--) {
            heapify(arr, n, i);            
           }
           for (int i = n-1; i >=0; i--) {
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr, i, 0);
           }
    }
    public static void heapsortmin(int arr[]){
        int n=arr.length;
        for (int i = n/2; i >=0; i--) {
         heapifymin(arr, n, i);            
        }
        for (int i = n-1; i >=0; i--) {
         int temp=arr[0];
         arr[0]=arr[i];
         arr[i]=temp;
         heapifymin(arr, i, 0);
        }
 }
 public static void heapifymin(int arr[],int n,int i){
    int max=i;
    int left=i*2+1;
    int right=i*2+2;
    if(left<n && arr[left]<arr[max]){
      max=left;
    }
    if(right<n && arr[right]<arr[max]){
      max=right;
    }
    if (max!=i) {
      int temp=arr[max];
      arr[max]=arr[i];
      arr[i]=temp;
      heapifymin(arr, n,max);
    }
    
}

    public static void main(String[] args) {
        int arr[]={1,2,4,5,3};
        heapsortmax(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+" ");
        }
        System.out.println();
        heapsortmin(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+" ");
        }
    }
}
