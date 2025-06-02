package leetcode.BinaryTree;

/*Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 

Example 1:


Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [0]
Output: [0]
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100 */

public class FlatternBinaryTreeToLinkedList {
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

    public TreeNode flatternHelper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = null, right = null;
        if (root.left != null) {
            left = flatternHelper(root.left);
        }
        if (root.right != null) {
            right = flatternHelper(root.right);
        }
        root.left = null;
        root.right = left;
        TreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = right;
        return root;
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        root = flatternHelper(root);
    }

    public static void main(String[] args) {

    }
}
