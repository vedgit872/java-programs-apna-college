package leetcode.BinaryTree;

/*Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 

Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 

Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
 

Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize? */

public class KthSmallestElementInABst {
    public static void main(String[] args) {

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

    static int knum;

    public int kthSmallest(TreeNode root, int k) {
        knum = 0;
        kth(root, k);
        return knum;
    }

    public int kth(TreeNode root, int k) {
        if (root.left != null) {
            k = kth(root.left, k);
        }
        if (k == -1) {
            return -1;
        }
        k--;
        if (k == 0) {
            knum = root.val;
            return -1;
        }
        if (root.right != null) {
            k = kth(root.right, k);
        }
        if (k == -1) {
            return -1;
        }
        return k;
    }
}
