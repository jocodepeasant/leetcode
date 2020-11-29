package 二叉树.q538_把二叉搜索树转换为累加树.s2;

import 二叉树.TreeNode;

/**
 * 递归法
 */
public class Solution {
    int pre = 0;

    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.right);
        root.val += pre;
        pre = root.val;
        helper(root.left);
    }
}
