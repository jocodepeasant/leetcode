package 动态规划.q1024_视频拼接.s1;

/**
 * 贪心算法：
 *
 * @author fzb
 * @date 2020/10/27 13:25
 */
class Solution {
    public int videoStitching(int[][] clips, int T) {
        int[] map = new int[T];
        for (int i = 0; i < clips.length; i++) {
            int start = clips[i][0];
            int end = clips[i][1];
            if (start < T && end > map[start]) {
                map[start] = end;
            }
        }
        int left = 1;
        int right = map[0];
        int res = 1;
        while (true) {
            if (right >= T) {
                return res;
            }
            int tmp = right;
            for (; left <= right; left++) {
                if (map[left] > tmp) {
                    tmp = map[left];
                }
            }
            if (tmp == right) {
                return -1;
            }
            left = right + 1;
            right = tmp;
            res++;
        }
    }
}
