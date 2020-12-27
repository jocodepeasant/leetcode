package 贪心算法.q5640_与数组中元素的最大异或值.s1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 字典树
 * 使用0-1的字典树存储nums数组的32位二进制数，从高位存储至低位，
 * 由于需要最大异或值，那么在遍历字典树时，高位应尽量选择与需异或数字该位置二进制数不同的树节点，
 * 即queries[i][0]当前位置的二进制数为0，那么字典树应尽量选择表示为1的节点。
 */
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Node root = new Node();
        int[] res = new int[queries.length];
        //queries每次都需要选择小于queries[i][1]的数异或，所以nums和queries都需要排序
        Arrays.sort(nums);
        Integer[] idx = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, Comparator.comparingInt(a -> queries[a][1]));
        int ni = 0;
        for (int i = 0; i < queries.length; i++) {
            //将可选数加入字典树
            while (ni < nums.length && nums[ni] <= queries[idx[i]][1]) {
                insert(nums[ni++], root);
            }
            //树中没有节点，赋值-1
            res[idx[i]] = ni == 0 ? -1 : search(queries[idx[i]][0], root);
        }
        return res;
    }

    private void insert(int n, Node root) {
        String s = Integer.toBinaryString(n);
        for (int i = 0; i < 32; i++) {
            char bin = (i >= 32 - s.length()) ? s.charAt(i - (32 - s.length())) : '0';
            if (bin == '0') {
                if (root.left == null) {
                    root.left = new Node();
                }
                root = root.left;
            } else {
                if (root.right == null) {
                    root.right = new Node();
                }
                root = root.right;
            }
        }
        root.val = n;
    }

    private int search(int n, Node root) {
        String s = Integer.toBinaryString(n);
        for (int i = 0; i < 32; i++) {
            char bin = (i >= 32 - s.length()) ? s.charAt(i - (32 - s.length())) : '0';
            if (bin == '0') {
                if (root.right != null) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            } else {
                if (root.left != null) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
        }
        return root.val ^ n;
    }

    /**
     * 字典树，存储数字从高位至低位的二进制值，表现为树的左右节点，左节点表示0，右节点表示1，
     * 当有数insert后，树高为32
     */
    class Node {
        public int val = -1;
        public Node left;
        public Node right;
    }
}