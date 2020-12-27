package 贪心算法.q5638_吃苹果的最大数目.s2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 贪心+优先队列
 */
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((Comparator.comparing(x -> x[0])));
        int res = 0;
        for (int i = 0; ; i++) {
            //保存新长出的苹果
            if (i < apples.length && apples[i] > 0) {
                queue.offer(new int[]{i + days[i], apples[i]});
            } else if (i >= apples.length && queue.isEmpty()) {
                break;
            }
            //弹出已经腐烂的苹果
            while (!queue.isEmpty() && queue.peek()[0] <= i) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                //苹果已吃完，弹出
                if (queue.peek()[1] == 1) {
                    queue.poll();
                } else {
                    queue.peek()[1] = -1;
                }
                res++;
            }
        }
        return res;
    }
}