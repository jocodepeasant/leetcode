package 未归类.q1030_距离顺序排列矩阵单元格.s2;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 桶排序
 */
public class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0, R - r0 - 1) + Math.max(c0, C - c0 - 1);
        ArrayList<LinkedList<int[]>> bucket = new ArrayList<>(maxDist + 1);
        for (int i = 0; i < maxDist + 1; i++) {
            bucket.add(new LinkedList<>());
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int dist = Math.abs(r0 - i) + Math.abs(c0 - j);
                bucket.get(dist).add(new int[]{i, j});
            }
        }
        int[][] res = new int[R * C][];
        int idx = 0;
        for (LinkedList<int[]> list : bucket) {
            for (int[] arr : list) {
                res[idx++] = arr;
            }
        }
        return res;
    }
}