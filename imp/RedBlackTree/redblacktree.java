package imp.RedBlackTree;

// Class representing Red-Black Tree
public class redblacktree {
    public Node root;

    // Constructor initializes the root to null
    redblacktree() {
        root = null;
    }

    // Node class for Red-Black Tree
    static class Node {
        int data;  // Value stored in the node
        Node left, right, parent; // Left, right child and parent node
        char color; // 'R' for red, 'B' for black

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
            this.color = 'R'; // New nodes are always red initially
        }
    }

    // Right Rotation
    public static Node rotateright(Node node) {
        Node x = node.left;
        Node y = x.right;
        
        x.right = node;
        node.left = y;
        
        if (y != null) {
            y.parent = node;
        }
        
        x.parent = node.parent;
        node.parent = x;
        
        return x;
    }

    // Left Rotation
    public static Node rotateleft(Node node) {
        Node x = node.right;
        Node y = x.left;
        
        x.left = node;
        node.right = y;
        
        if (y != null) {
            y.parent = node;
        }
        
        x.parent = node.parent;
        node.parent = x;
        
        return x;
    }

    // Flags for rotation cases
    boolean ll = false, rr = false, lr = false, rl = false;

    // Helper function to insert a node
    Node insertHelp(Node root, int data) {
        boolean conflict = false;

        // Base case: if root is null, create a new node
        if (root == null) {
            return new Node(data);
        }

        // If data is smaller, go to left subtree
        if (data < root.data) {
            root.left = insertHelp(root.left, data);
            root.left.parent = root;
            
            // Check for red-red conflict
            if (root != this.root && root.color == 'R' && root.left.color == 'R') {
                conflict = true;
            }
        } 
        // If data is greater, go to right subtree
        else {
            root.right = insertHelp(root.right, data);
            root.right.parent = root;
            
            // Check for red-red conflict
            if (root != this.root && root.color == 'R' && root.right.color == 'R') {
                conflict = true;
            }
        }

        // Perform rotations to balance the tree
        if (ll) {
            root = rotateleft(root);
            root.color = 'B';
            root.left.color = 'R';
            ll = false;
        } else if (rr) {
            root = rotateright(root);
            root.color = 'B';
            root.right.color = 'R';
            rr = false;
        } else if (rl) {
            root.right = rotateright(root.right);
            root.right.parent = root;
            root = rotateleft(root);
            root.color = 'B';
            root.left.color = 'R';
            rl = false;
        } else if (lr) {
            root.left = rotateleft(root.left);
            root.left.parent = root;
            root = rotateright(root);
            root.color = 'B';
            root.right.color = 'R';
            lr = false;
        }

        // Handle red-red conflicts
        if (conflict) {
            if (root.parent.right == root) {
                if (root.parent.left == null || root.parent.left.color == 'B') {
                    if (root.left != null && root.left.color == 'R') {
                        rl = true;
                    } else if (root.right != null && root.right.color == 'R') {
                        ll = true;
                    }
                } else {
                    root.parent.left.color = 'B';
                    root.color = 'B';
                    if (root.parent != this.root) {
                        root.parent.color = 'R';
                    }
                }
            } else {
                if (root.parent.right == null || root.parent.right.color == 'B') {
                    if (root.left != null && root.left.color == 'R') {
                        rr = true;
                    } else if (root.right != null && root.right.color == 'R') {
                        lr = true;
                    }
                } else {
                    root.parent.right.color = 'B';
                    root.color = 'B';
                    if (root.parent != this.root) {
                        root.parent.color = 'R';
                    }
                }
            }
        }
        
        return root;
    }

    // Insert function
    public void insert(int data) {
        if (this.root == null) {
            this.root = new Node(data);
            this.root.color = 'B'; // Root should always be black
        } else {
            this.root = insertHelp(this.root, data);
        }
    }

    // In-order traversal helper function
    void inorderHelper(Node node) {
        if (node != null) {
            inorderHelper(node.left);
            System.out.print(node.data + " ");
            inorderHelper(node.right);
        }
    }

    // Public method for in-order traversal
    public void inorder() {
        inorderHelper(this.root);
        System.out.println(); // Print newline after traversal
    }

    // Main method to test the Red-Black Tree
    public static void main(String[] args) {
        redblacktree t = new redblacktree();
        int[] arr = {1, 2, 6, 3, 7, 8, 9};
        
        for (int i = 0; i < arr.length; i++) {
            t.insert(arr[i]);
        }
        t.inorder();
    }
}
