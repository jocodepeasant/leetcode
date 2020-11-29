package 二叉树.q968_监控二叉树.s1;

import 二叉树.TreeNode;

/**
 * 后序递归
 */
public class Solution {
    int res = 0;

    public int minCameraCover(TreeNode root) {
        // 节点值0：未监视，1：已监视，2：摄像头
        if (lrd(root) == 0) res++;
        return res;
    }

    private int lrd(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int left = lrd(root.left);
        int right = lrd(root.right);
        // 有子节点未被监视，需装摄像头
        if (left == 0 || right == 0) {
            res++;
            return 2;
        }
        // 子节点均被监视，当前节点无需设置摄像头或置为被监视
        if (left == 1 && right == 1) {
            return 0;
        }
        // 子节点至少有一个摄像头，设为被监视
        if (left + right >= 3) {
            return 1;
        }
        return -1;
    }
}
