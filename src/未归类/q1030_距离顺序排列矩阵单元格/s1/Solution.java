package 未归类.q1030_距离顺序排列矩阵单元格.s1;

import java.util.Arrays;

/**
 * 直接排序
 */
public class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res[i * C + j][0] = i;
                res[i * C + j][1] = j;
            }
        }
        Arrays.sort(res, (x, y) -> Math.abs(x[0] - r0) + Math.abs(x[1] - c0) - Math.abs(y[0] - r0) - Math.abs(y[1] - c0));
        return res;
    }
}