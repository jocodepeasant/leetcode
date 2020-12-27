package 贪心算法.q84_柱状图中最大的矩形.s4;

/**
 * 使用两个数组保存小于当前边的左边界和右边界，极端情况下（数组递增或递增）时间复杂度O(N*N)
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        //保存左右边界位置
        int[] left = new int[len];
        int[] right = new int[len];
        //初始化
        left[0] = -1;
        right[len - 1] = len;
        for (int i = 1; i < len; i++) {
            int j = i - 1;
            //找到左边界
            while (j >= 0 && heights[j] >= heights[i]) {
                j = left[j];
            }
            left[i] = j;
        }
        for (int i = len - 2; i >= 0; i--) {
            int j = i + 1;
            //找到右边界
            while (j < len && heights[j] >= heights[i]) {
                j = right[j];
            }
            right[i] = j;
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }
}