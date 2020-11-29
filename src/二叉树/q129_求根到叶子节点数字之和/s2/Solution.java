package 二叉树.q129_求根到叶子节点数字之和.s2;

import 二叉树.TreeNode;

import java.util.LinkedList;

/**
 * 迭代 BFS
 */
class Solution {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<Integer> numQueue = new LinkedList<>();
        nodeQueue.add(root);
        numQueue.add(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            Integer num = numQueue.remove();
            if (node.left == null && node.right == null) {
                sum += num;
            } else {
                if (node.left != null) {
                    nodeQueue.add(node.left);
                    numQueue.add(num * 10 + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                    numQueue.add(num * 10 + node.right.val);
                }
            }
        }
        return sum;
    }
}
