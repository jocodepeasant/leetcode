package 未归类.q.s1;

import java.util.Arrays;

/**
 *
 */
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }
        Arrays.sort(points, (x, y) -> {
            if (x[0] != y[0]) {
                return x[0] - y[0];
            } else {
                return x[1] - y[1];
            }
        });
        int[] pre = points[0];
        int res = 1;
        for (int i = 1; i < points.length; i++) {
            if (pre[0] > points[i][1] || pre[1] < points[i][0]) {
                res++;
                pre = points[i];
            } else {
                pre[0] = Math.max(pre[0], points[i][0]);
                pre[1] = Math.min(pre[1], points[i][1]);
            }
        }
        return res;
    }
}