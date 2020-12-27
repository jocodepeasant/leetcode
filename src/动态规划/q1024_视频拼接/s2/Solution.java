package 动态规划.q1024_视频拼接.s2;

import java.util.Arrays;

/**
 * 动态规划
 * @author fzb
 * @date 2020/10/27 13:27
 */
class Solution {
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int[] n : clips) {
                if (n[0] < i && n[1] >= i) {
                    dp[i] = Math.min(dp[i], dp[n[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }
}
