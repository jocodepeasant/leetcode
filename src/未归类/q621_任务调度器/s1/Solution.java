package 未归类.q621_任务调度器.s1;

import java.util.Arrays;

/**
 * 贪心算法
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Integer[] cut = new Integer[26];
        Arrays.fill(cut, new Integer(0));
        for (char task : tasks) {
            cut[task - 'A']++;
        }
        Arrays.sort(cut, (a, b) -> b - a);
        //初始化
        int need = (cut[0] - 1) * n;
        int res = need + cut[0];
        for (int i = 1; i < 26; i++) {
            if (cut[i].equals(cut[0])) {
                need -= cut[i] - 1;
                res += 1;
            } else {
                need -= cut[i];
            }
        }
        if (need < 0) {
            res -= need;
        }
        return res;
    }
}