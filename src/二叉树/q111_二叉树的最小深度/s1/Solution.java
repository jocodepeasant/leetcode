package 二叉树.q111_二叉树的最小深度.s1;

import 二叉树.TreeNode;

import java.util.LinkedList;

/**
 * 迭代，BFS
 */
class Solution {
    public int minDepth(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (true) {
            int size = queue.size();
            for (; size > 0; size--) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return ++res;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res++;
        }
    }
}