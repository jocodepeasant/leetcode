package 二叉树.q226_翻转二叉树.s2;

import 二叉树.TreeNode;

import java.util.LinkedList;

/**
 * 迭代法
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        LinkedList<TreeNode> tmp = new LinkedList<>();
        tmp.add(root);
        while(!tmp.isEmpty()){
            TreeNode node=tmp.remove();
            swapChil(node);
            if (node.left!=null){
                tmp.add(node.left);
            }
            if (node.right!=null){
                tmp.add(node.right);
            }
        }
        return root;
    }

    private void swapChil(TreeNode root){
        TreeNode node = root.left;
        root.left=root.right;
        root.right=node;
    }
}
