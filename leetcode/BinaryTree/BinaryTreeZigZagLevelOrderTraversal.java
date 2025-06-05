package leetcode.BinaryTree;

/*Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZagLevelOrderTraversal {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        if (root == null) {
            return ls;
        }
        int i = 1;
        int level = 0;
        int nextLevel = 0;
        List<Integer> temp = new ArrayList<>();
        Queue<TreeNode> track = new LinkedList<>();
        track.offer(root);
        level++;
        while (!track.isEmpty()) {
            if (level > 0) {
                level--;
                TreeNode t = track.poll();
                temp.add(t.val);
                if (t.left != null) {
                    track.offer(t.left);
                    nextLevel++;
                }
                if (t.right != null) {
                    track.offer(t.right);
                    nextLevel++;
                }
            } else {
                if (i % 2 == 0) {
                    Collections.reverse(temp);
                }
                ls.add(temp);
                if (nextLevel == 0) {
                    break;
                }
                temp = new ArrayList<>();
                level = nextLevel;
                nextLevel = 0;
                i++;
            }
        }
        if (!temp.isEmpty()) {
            if (i % 2 == 0) {
                Collections.reverse(temp);
            }
            ls.add(temp);
        }
        return ls;
    }

    public static void main(String[] args) {

    }
}
