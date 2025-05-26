package leetcode.BinaryTree;

/*Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]

Output: [1,3,2]

Explanation:



Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [4,2,6,5,7,1,3,9,8]

Explanation:



Example 3:

Input: root = []

Output: []

Example 4:

Input: root = [1]

Output: [1]

 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100 */

import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> li = new LinkedList<>();
        if (root == null) {
            return li;
        }
        if (root.left != null) {
            List<Integer> left = inorderTraversal(root.left);
            li.addAll(left);
        }
        li.add(root.val);
        if (root.right != null) {
            List<Integer> right = inorderTraversal(root.right);
            li.addAll(right);
        }
        return li;
    }

    public static void main(String[] args) {

    }
}
