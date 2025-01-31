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



    //part 2
   // Function to convert an array to a balanced BST
   public static Node array_to_bst(int arr[], int st, int end) {
    if (st <= end) {
        int mid = (st + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = array_to_bst(arr, st, mid - 1);  // Left subtree
        root.right = array_to_bst(arr, mid + 1, end); // Right subtree
        return root;
    }
    return null;
}

// Helper function to do in-order traversal and store values in the array
// This function needs to return the updated index after insertion in the array
public static int inarray(int[] arra, Node root, int i) {
    if (root == null) {
        return i;
    }
    
    // Traverse left
    i = inarray(arra, root.left, i);
    
    // Store root data in the array
    arra[i] = root.data;
    i++; // Increment index
    
    // Traverse right
    i = inarray(arra, root.right, i);
    
    return i; // Return updated index
}

// Function to convert a BST to a balanced BST
public static Node to_balanced(Node root) {
    // First, get the array of the elements from the BST
    int[] arra = new int[100]; // Arbitrary size, can be dynamically calculated based on the number of nodes
    int index = 0;
    index = inarray(arra, root, index);  // Store values in the array

    // Convert the array back to a balanced BST
    root = array_to_bst(arra, 0, index - 1); // Correct the end index here
    return root;
}   
static class info {
    boolean isbst;
    int size;
    int min;
    int max;
    info(boolean isbst, int size,int min, int max){
        this.isbst=isbst;
        this.size=size;
        this.min=min;
        this.max=max;
    }
}
public static int maxbst=0;
public static info find_largest_bst(Node root){
    if(root==null){
        return new info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
    info fleft=find_largest_bst(root.left);
    info fright=find_largest_bst(root.right);
    boolean isbst;
    int size=fleft.size+1+fright.size;;
    if (fleft.isbst && fright.isbst && root.data>fleft.max && root.data<fright.min) {
        isbst=true;
        maxbst=Math.max(maxbst,size);
    }else {
        isbst=false;
    }
    return new info(isbst,size,Math.min(root.data,Math.min(fleft.min, fright.min)),Math.max(root.data, Math.max(fleft.max,fright.max)));
}

// public static Node merge(Node root1,Node root2){
//      if (root1==null) {
//         return root2;
//      }
//      if (root2==null) {
//         return root1;
//      }

//     i have taken array here ideally arraylist should be taken 
//     int array1[]=new int[100];
//     int array2[]=new int[100];
//     int array3[]=new int[100];
//     array_to_bst(array1, 0, array1.length-1);
//     array_to_bst(array2, 0, array2.length-1);
//     int i=0;
//     int j=0;
//     int z=0;
//     while (i<array1.length && j<array2.length) {
//         if (array1[i]<array2[j]) {
//             array3[z]=array1[i];
//             i++;
//             z++;
//         }
//         else{
//             array3[z]=array2[j];
//             j++;
//             z++;
//         }
//     }
//     while (i<array1.length) {
//         array3[z]=array1[i];
//         i++;
//         z++;
//     }
//     while (j<array2.length) {
//         array3[z]=array2[j];
//             j++;
//             z++;
//     }
//    return array_to_bst(array3, 0, array3.length-1);
// }

//merger of two sub trees witharraylist 
public static Node combine(Node root1, Node root2) {
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
    ArrayList<Integer> list3 = new ArrayList<>();

    treeToList(root1, list1);
    treeToList(root2, list2);

    mergeArrays(list1, list2, list3);

    return listToTree(list3, 0, list3.size() - 1);
}

private static void treeToList(Node root, ArrayList<Integer> list) {
    if (root == null) return;
    treeToList(root.left, list);
    list.add(root.data);
    treeToList(root.right, list);
}

private static void mergeArrays(ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> list3) {
    int i = 0, j = 0, z = 0;
    while (i < list1.size() && j < list2.size()) {
        if (list1.get(i) < list2.get(j)) {
            list3.add(list1.get(i));
            i++;
        } else {
            list3.add(list2.get(j));
            j++;
        }
        z++;
    }
    while (i < list1.size()) {
        list3.add(list1.get(i));
        i++;
        z++;
    }
    while (j < list2.size()) {
        list3.add(list2.get(j));
        j++;
        z++;
    }
}

private static Node listToTree(ArrayList<Integer> list, int start, int end) {
    if (start > end) return null;
    int mid = (start + end) / 2;
    Node node = new Node(list.get(mid));
    node.left = listToTree(list, start, mid - 1);
    node.right = listToTree(list, mid + 1, end);
    return node;
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

        System.out.println();
        Node root4=new Node(0);
        int array[]={3,5,6,8,11,12};
        root4=array_to_bst(array, 0, array.length-1);
        inorder(root4);
        System.out.println(root4.data);

        System.out.println();
        root=to_balanced(root);
        inorder(root);
        System.out.println();
        System.out.print(root.data);
        // Creating a False BST:
        //        10
        //       /  \
        //      5    15
        //     / \   /
        //    3   12 6   <- This makes it invalid! (12 should not be in left of 10, 6 should not be in right of 5)
        
        Node root3 = new Node(10);
        root3.left = new Node(5);
        root3.right = new Node(15);
        root3.left.left = new Node(3);
        root3.left.right = new Node(8);
        root3.right.left = new Node(12);
        bst.find_largest_bst(root3);
        System.out.println();
        System.out.println();
        System.out.println(maxbst);

        Node root5 = new Node(9);
        root5.left = new Node(4);
        root5.right = new Node(14);
        root5.left.left = new Node(2);
        root5.left.right = new Node(7);
        root5.right.left = new Node(13);
        System.out.println();
        System.out.println();

        Node root6=combine(root3, root5);
        inorder(root6);

        


    }
}
