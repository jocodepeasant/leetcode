package 二叉树.q129_求根到叶子节点数字之和.s1;

import 二叉树.TreeNode;

/**
 * 递归 DFS
 */
class Solution {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            return num;
        } else {
            return dfs(root.left, num) + dfs(root.right, num);
        }
    }
}
