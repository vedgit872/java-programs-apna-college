package leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if (root == null) {
            return ls;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1, sublevel = 0;
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            level--;
            if (temp.left != null) {
                q.offer(temp.left);
                sublevel++;
            }
            if (temp.right != null) {
                q.offer(temp.right);
                sublevel++;
            }
            if (level == 0) {
                ls.add(temp.val);
                level = sublevel;
                sublevel = 0;
            }
        }
        return ls;
    }

    public static void main(String[] args) {

    }
}
