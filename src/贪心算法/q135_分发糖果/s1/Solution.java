package 贪心算法.q135_分发糖果.s1;

import java.util.Arrays;

/**
 * 贪心（两次遍历）
 * 本题的主要思想是贪心，由于评分高的必须获取更多的糖果，夹在递增和递减序列中间的极大值顶点需要取左右两边的最大值+1，所有孩子至少有一个糖果，
 * 定义两个数组，为每个位置附初始值1，分别从左右两边遍历：
 * 如果当前孩子评分大于前面孩子评分，则当前孩子获得的糖果数=前面孩子获得糖果数+1
 * 否则，不进行操作
 * 结合两个数组，取每个位置的最大值，即为当前孩子获取的糖果数。
 */
class Solution {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int res = left[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
            res += Math.max(left[i], right[i]);
        }
        return res;
    }
}