package leetcode.BinaryTree;

public class MinDepthOfBinaryTree {
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

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.right == null && root.left == null) {
            return 1;
        }
        int l = Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;
        if (root.right != null) {
            r = minDepth(root.right);
        }
        if (root.left != null) {
            l = minDepth(root.left);
        }
        return Math.min(r, l) + 1;
    }

    public static void main(String[] args) {

    }
}
