package leetcode.BinaryTree;
/*Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height-balanced binary search tree.

 

Example 1:


Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
Example 2:

Input: head = []
Output: []
 

Constraints:

The number of nodes in head is in the range [0, 2 * 104].
-105 <= Node.val <= 105 */
public class ConvertASortedListToBST {
    public class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next =next ;}
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int height(TreeNode root){
        int right = 0, left = 0;
        if(root == null) return 0;
        if(root.right != null){
            right = height(root.right);
        }
        if(root.left != null){
            left = height(root.left);
        }
        return Math.max(left, right) + 1;
    }

    public int bf(TreeNode root){
        if (root == null) return 0;
        return height(root.left) - height(root.right);
    }

    public TreeNode leftRotate(TreeNode x){
        TreeNode y = x.right;
        TreeNode t2 = y.left;

        y.left = x;
        x.right = t2;

        return y;
    }

    public TreeNode rightRotate(TreeNode x){
        TreeNode y = x.left;
        TreeNode t2 = y.right;

        y.right = x;
        x.left = t2;

        return y;
    }

    public TreeNode insertAVL(TreeNode temp, TreeNode root){
        if (root == null) return temp;

        if (temp.val < root.val) {
            root.left = insertAVL(temp, root.left);
        } else if (temp.val > root.val) {
            root.right = insertAVL(temp, root.right);
        } else {
            return root;
        }

        int bf = bf(root);
        if (bf > 1 && temp.val < root.left.val) {
            return rightRotate(root);
        }
        if (bf < -1 && temp.val > root.right.val) {
            return leftRotate(root);
        }
        if (bf > 1 && temp.val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (bf < -1 && temp.val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root; 
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;

        TreeNode node = new TreeNode(head.val);
        head = head.next;

        while(head != null){
            TreeNode temp = new TreeNode(head.val);
            head = head.next;
            node = insertAVL(temp, node);
        }

        return node;
    }
}
