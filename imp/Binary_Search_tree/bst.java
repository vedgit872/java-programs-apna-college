package imp.Binary_Search_tree;

import java.util.ArrayList;

public class bst {
    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildtree(Node root, int n) {
        if (root == null) {
            return new Node(n);
        }
        if (n > root.data) {
            root.right = buildtree(root.right, n);
        } else {
            root.left = buildtree(root.left, n);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        return key < root.data ? search(root.left, key) : search(root.right, key);
    }

    public static Node del(Node root, int val) {
        if (root == null) {  // Fix: Handle null case
            return null;
        }

        if (val < root.data) {
            root.left = del(root.left, val);
        } else if (val > root.data) {
            root.right = del(root.right, val);
        } else {
            // Case 1: No children
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: One child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: Two children
            Node is = findInorderSuccessor(root.right);
            root.data = is.data;
            root.right = del(root.right, is.data); // Fix: Assign result back
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    public static void printa(ArrayList<Integer> a) {
        for (int i=0;i<a.size();i++) {
            System.out.print(a.get(i) + "->");
        }
        System.out.println("N");
    }

    public static void leafPaths(Node root, ArrayList<Integer> a) {
        if (root == null) {
            return;
        }

        // Add the current node to the path
        a.add(root.data);

        // If it is a leaf node, print the path
        if (root.left == null && root.right == null) {
            printa(a);
        } 
            // Recur for left and right children
            leafPaths(root.left, a);
            leafPaths(root.right, a);
        

        // Backtrack: Remove the last element before returning to the parent
        a.remove(a.size() - 1);
    }
    
    public static void inrange(Node root,int a,int b){
        if (root==null) {
            return;
        }
        if (root.data>=a && root.data<=b) {
            inrange(root.left, a, b);
            System.out.print(root.data+" ");
            inrange(root.right, a, b);
        }else if (root.data<a) {
            inrange(root.right, a, b);
        }else if(root.data>b){
            inrange(root.left, a, b);
        }
        return;
    }
    public static boolean validate(Node root, Node min, Node max) {
        if (root == null)
            return true; // An empty tree is a valid BST
    
        // Ensure root’s data is greater than min (if min is not null)
        if (min != null && root.data <= min.data)  
            return false;
    
        // Ensure root’s data is less than max (if max is not null)
        if (max != null && root.data >= max.data)  
            return false;
    
        // Recursively validate left and right subtrees
        return validate(root.left, min, root) && validate(root.right, root, max);
    }
    public static void MirrorA_Bst(Node root){
        if (root==null) {
            return;
        }
        Node temp;
        temp=root.right;
        root.right=root.left;
        root.left=temp;
        MirrorA_Bst(root.left);
        MirrorA_Bst(root.right);
        return;
    } 
    public static void main(String[] args) {
        int arr[] = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = bst.buildtree(root, arr[i]);
        }

        System.out.println("Inorder Traversal:");
        bst.inorder(root);
        System.out.println();

        // Search for a value
        System.out.println("Search for 6: " + bst.search(root, 6));

        // Delete node 3 and print again
        root = bst.del(root, 3);
        System.out.println("Inorder after deleting 3:");
        bst.inorder(root);
        System.out.println();
        System.out.println();
        inrange(root, 1, 4);
        System.out.println();
        ArrayList<Integer> a=new ArrayList<>();
        leafPaths(root, a);
        System.out.println();
        System.out.println(validate(root, null, null));
        // Creating a False BST:
        //        10
        //       /  \
        //      5    15
        //     / \   /
        //    3   12 6   <- This makes it invalid! (12 should not be in left of 10, 6 should not be in right of 5)
        
        Node root1 = new Node(10);
        root1.left = new Node(5);
        root1.right = new Node(15);
        root1.left.left = new Node(3);
        root1.left.right = new Node(12); //  Incorrect placement (should be in right subtree of 10)
        root1.right.left = new Node(6);  // Incorrect placement (should be in left subtree of 5)
        System.out.println();
        System.out.println(validate(root1, null, null));
        Node root2 = new Node(10);
        root2.left = new Node(5);
        root2.right = new Node(15);
        root2.left.left = new Node(3);
        root2.left.right = new Node(6); //  Incorrect placement (should be in right subtree of 10)
        root2.right.left = new Node(12);
        MirrorA_Bst(root2);
        inorder(root2);

    }
}
