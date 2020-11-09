package 未归类.q973_最接近原点的K个点.s1;

import java.util.PriorityQueue;

/**
 * 优先队列
 */
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(K + 1, (x, y) ->
                y[0] * y[0] + y[1] * y[1] - x[0] * x[0] - x[1] * x[1]
        );
        for (int i = 0; i < points.length; i++) {
            queue.add(points[i]);
            //取出，减少优先队列内部比较次数
            if (queue.size() > K) {
                queue.poll();
            }
        }
        int[][] res = new int[K][];
        queue.toArray(res);
        return res;
    }
}