package 二叉树.q226_翻转二叉树.s1;


import 二叉树.TreeNode;

/**
 * 递归法
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        TreeNode tmp=root.right;
        root.right=root.left;
        root.left=tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
