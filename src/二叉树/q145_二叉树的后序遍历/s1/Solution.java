package 二叉树.q145_二叉树的后序遍历.s1;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单递归
 */
public class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }
}
