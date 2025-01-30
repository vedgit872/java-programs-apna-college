package imp.Binary_Search_tree;

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
    }
}
