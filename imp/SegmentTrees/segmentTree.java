package imp.SegmentTrees;

public class segmentTree {
    static int tree[];
    public static void init(int n){
         tree=new int[4*n];
    }
    public static int create(int arr[],int start,int end,int i){
        if(start==end){
            tree[i]=arr[start];
            return tree[i];
        }
        int mid=(end-start)/2+start;
        int l=create(arr, start, mid, 2*i+1);
        int r=create(arr, mid+1, end, 2*i+2);
        tree[i]=l+r;
        return tree[i];
    }
    public static int subArraySumHelper(int i,int si,int sj,int qi,int qj){
        if(si>=qj || sj<=qi){//no overlap
            return 0;
        }
        else if(qi<=si && qj>=sj){//complete overlap of the si,sj in query range
            return tree[i];
        }else{
        int mid=(si+sj)/2;
        int left=subArraySumHelper(2*i+1, si, mid, qi, qj);
        int right=subArraySumHelper(2*i+2, mid+1, sj, qi, qj);
        return left+right;
        }
    }
    public static int subArraySum(int arr[],int qi,int qj){
        int n=arr.length;
        return subArraySumHelper(0,0,n-1,qi,qj);
    }
    public static void updateStHelper(int diff,int si,int sj,int i,int ind){
        if(si>i || sj<i ){
            return;
        }
        tree[ind]+=diff;
        if(si!=sj){
        int mid=(si+sj)/2;
        updateStHelper(diff, si, mid, i, 2*ind+1);
        updateStHelper(diff, mid+1, sj, i, 2*ind+2);
        }
    }
    public static void updateSt(int arr[],int val,int i){
        int diff=val-arr[i];
        arr[i]+=diff;
        updateStHelper(diff,0,arr.length-1,i,0);
    }
    public static void main(String args[]){
        int arr[]={1,2,3,4,5,6,7,8};
        int n=arr.length;
        init(n);
        create(arr, 0, n-1, 0);
        // for (int i = 0; i < tree.length; i++) {
        //     System.out.println(tree[i]);
        // }
        // System.out.println(subArraySum(arr, 2, 5));
        updateSt(arr, 2, 2);
        for (int i = 0; i < tree.length; i++) {
            System.out.println(tree[i]);
        }
    }
}
