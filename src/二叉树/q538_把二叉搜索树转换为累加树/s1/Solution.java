package 二叉树.q538_把二叉搜索树转换为累加树.s1;

import 二叉树.TreeNode;

import java.util.LinkedList;

/**
 * 迭代法
 */
public class Solution {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode res = root;
        int pre = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            root.val += pre;
            pre = root.val;
            root = root.left;
        }
        return res;
    }
}
