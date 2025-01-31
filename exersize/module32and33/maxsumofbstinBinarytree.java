package exersize.module32and33;

public class maxsumofbstinBinarytree {
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
    public static class Info {
        boolean isBST;
        int maxsum;  // Maximum sum of BST in this subtree
        int min;  // Minimum value in the subtree
        int max;  // Maximum value in the subtree
    
        Info(boolean isBST, int maxsum, int min, int max) {
            this.isBST = isBST;
            this.maxsum = maxsum;
            this.min = min;
            this.max = max;
        }
    }
    
    public static int maxBSTSum = 0; // Stores the maximum BST sum found
    
    public static Info maxsum(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
    
        Info left = maxsum(root.left);
        Info right = maxsum(root.right);
    
        // Check if current subtree is a BST
        if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
            int sum = left.maxsum + right.maxsum + root.data; // Compute sum of BST
            maxBSTSum = Math.max(maxBSTSum, sum); // Update global max sum
            return new Info(true, sum, Math.min(root.data, left.min), Math.max(root.data, right.max));
        } else {
            // If not a BST, return the maximum sum from a valid BST found so far
            return new Info(false, Math.max(left.maxsum, right.maxsum), 0, 0);
        }
    }
    
    // Helper function to start the process
    public static int findMaxBSTSum(Node root) {
        maxBSTSum = 0;  // Reset global variable before computation
        maxsum(root);
        return maxBSTSum;
    }
    
    public static void main(String args[]){
        Node root1 = new Node(10);
        root1.left = new Node(5);
        root1.right = new Node(15);
        root1.left.left = new Node(3);
        root1.left.right = new Node(11); 
        root1.right.left = new Node(12);

        System.out.println(findMaxBSTSum(root1));
    }
}
