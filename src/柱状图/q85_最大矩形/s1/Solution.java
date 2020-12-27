package 柱状图.q85_最大矩形.s1;

/**
 * 暴力：
 * 对于每个为'1'的位置，求出以其为右下点所构成矩形的最大面积。
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] widths = new int[m][n];
        int res = 0;
        //从左往右遍历计算每个点的宽度
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    widths[i][j] = j > 0 ? widths[i][j - 1] + 1 : 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (widths[i][j] > 0) {
                    int k = i;
                    int width = widths[i][j];
                    //往上遍历，计算当前点位的最大矩形面积
                    while (k >= 0 && widths[k][j] > 0) {
                        width = Math.min(width, widths[k][j]);
                        res = Math.max(res, width * (i - k + 1));
                        k--;
                    }
                }
            }
        }
        return res;
    }
}