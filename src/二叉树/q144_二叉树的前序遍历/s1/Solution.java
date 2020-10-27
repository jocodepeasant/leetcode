package 二叉树.q144_二叉树的前序遍历.s1;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归
 */
class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }
}
