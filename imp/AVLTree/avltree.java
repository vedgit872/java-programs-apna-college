package imp.AVLTree;

public class avltree {
    static class Node{
        // so that it knows its height perfectly well and we do not have to calculate it again and again 
        int data,height;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            height=1;
            this.left=null;
            this.right=null;
        }
    }
    public static Node root=null;

    public static int height(Node root){
        if (root==null) {
            return 0;
        }
        return root.height;
    }
    public static Node leftRotate(Node x){
        Node y=x.right;
        Node t2=y.left;

        y.left=x;
        x.right=t2;

        x.height=Math.max(height(x.left), height(x.right))+1;
        y.height=Math.max(height(y.left), height(y.right))+1;
        return y;
    }
    public static Node rightRotate(Node x){
        Node y=x.left;
        Node t2=y.right;

        y.right=x;
        x.left=t2;

        x.height=Math.max(height(x.left), height(x.right))+1;
        y.height=Math.max(height(y.left), height(y.right))+1;
        return y;
    }
    
    public static int bf(Node root){
        if (root==null) {
            return 0;
        }
        else{
            return height(root.left)-height(root.right);
        }
    }
        public static Node insert(Node root, int key) {
            if (root == null) return new Node(key);
        
            // Standard BST insertion
            if (key < root.data) {
                root.left = insert(root.left, key);
            } else if (key > root.data) {
                root.right = insert(root.right, key);
            } else {
                return root; // No duplicates allowed
            }
        
            // Update height **before** checking balance factor
            root.height = Math.max(height(root.left), height(root.right)) + 1;
        
            int bf = bf(root);
        
            // **Rotation Cases**
            // LL Case
            if (bf > 1 && key < root.left.data) {
                return rightRotate(root);
            }
            // RR Case
            if (bf < -1 && key > root.right.data) {
                return leftRotate(root);
            }
            // LR Case
            if (bf > 1 && key > root.left.data) {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
            // RL Case
            if (bf < -1 && key < root.right.data) {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        
            return root;  // Return balanced root
        }
    public static void preorder(Node root){
        if (root==null) {
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root){
        if (root==null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        root=insert(root,40);
        root=insert(root,20);
        root=insert(root,10);
        root=insert(root,25);
        root=insert(root,30);
        root=insert(root,22);
        root=insert(root,50);
        preorder(root);
        System.out.println();
        inorder(root);

    }
}