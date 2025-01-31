package exersize.module32and33;

public class kthsmallestancestor {
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
    static int count = 0;  // To track the count of nodes visited

public static int smallest(Node root, int k) {
    if (root == null) {
        return -1; // Sentinel value indicating not found
    }

    // Search in the left subtree
    int left = smallest(root.left, k);

    // If the left subtree already found the k-th element, return it
    if (left != -1) {
        return left;
    }

    // Increment count
    count++;

    // If count matches k, we found the k-th smallest element
    if (count == k) {
        return root.data;  // Return the k-th smallest element
    }

    // Search in the right subtree
    return smallest(root.right, k);
}
    public static void main(String[] args) {
        Node root1 = new Node(10);
        root1.left = new Node(5);
        root1.right = new Node(15);
        root1.left.left = new Node(3);
        root1.left.right = new Node(6); 
        root1.right.left = new Node(12);

        
        System.out.println(smallest(root1, 3));
    }
}
