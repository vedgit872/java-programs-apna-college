package leetcode.BinaryTree;

/*Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        if (root == null) {
            return ls;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < level; i++) {
                TreeNode t = q.poll();
                temp.add(t.val);
                if (t.left != null) {
                    q.offer(t.left);
                }
                if (t.right != null) {
                    q.offer(t.right);
                }
            }
            ls.add(temp);
        }
        return ls;
    }

    public static void main(String[] args) {

    }
}
