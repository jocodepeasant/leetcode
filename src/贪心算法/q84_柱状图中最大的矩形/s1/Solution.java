package 贪心算法.q84_柱状图中最大的矩形.s1;

/**
 * 暴力解法：
 * 将当前边作为矩形的高度，矩形的左右边界是第一个小于当前高度的边，rightIdx-leftIdx-1即为宽度，宽*高求出面积，
 * 求出所有的边为高度的矩形面积，其中的最大值即为柱状图的最大矩形面积。
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int cut = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] >= heights[i]) {
                    cut++;
                } else {
                    break;
                }
            }
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] >= heights[i]) {
                    cut++;
                } else {
                    break;
                }
            }
            res = Math.max(res, heights[i] * cut);
        }
        return res;
    }
}