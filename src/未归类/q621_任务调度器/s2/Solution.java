package 未归类.q621_任务调度器.s2;

/**
 * 贪心算法2：
 * 排列好的任务有两种情况，一种是有等待时间，一种是没有等待时间，没有等待时间的结果即为task数，
 * 有等待时间的结果为（执行次数最多任务的次数-1）*任务间隔+不包含在该任务间隔中的个数。
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cut = new int[26];

        for (int task : tasks) {
            cut[task - 'A']++;
        }
        int max = 0;
        for (int c : cut) {
            max = Math.max(max, c);
        }

        int rightCut = 0;
        for (int c : cut) {
            if (c == max) {
                rightCut++;
            }
        }

        return Math.max(tasks.length, (max - 1) * (n + 1) + rightCut);
    }
}