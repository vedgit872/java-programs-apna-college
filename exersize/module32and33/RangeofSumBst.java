package exersize.module32and33;

public class RangeofSumBst {
   public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static int RangeSum(Node root,int l,int r){
        if (root==null) {
            return 0;
        }
        int left=RangeSum(root.left,l,r);
        int right=RangeSum(root.right, l, r);
        if (root.data>=l && root.data<=r) {
            return left+right+root.data;
        }else if (root.data<l) {
            return right;
        }else if(root.data>r){
            return left;
        }
        return 0;
    }
    public static void main(String[] args) {
        Node root1 = new Node(10);
        root1.left = new Node(5);
        root1.right = new Node(15);
        root1.left.left = new Node(3);
        root1.left.right = new Node(6); 
        root1.right.left = new Node(12);

        System.out.println(RangeSum(root1, 11, 13));
    }
}
