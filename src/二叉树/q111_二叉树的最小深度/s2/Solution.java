package 二叉树.q111_二叉树的最小深度.s2;

import 二叉树.TreeNode;

/**
 * 递归，DFS（时间长）
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return minDepth(root, 1);
    }

    private int minDepth(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            return depth;
        }
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if (root.left != null) {
            left = minDepth(root.left, depth + 1);
        }
        if (root.right != null) {
            right = minDepth(root.right, depth + 1);
        }
        return Math.min(left, right);
    }
}