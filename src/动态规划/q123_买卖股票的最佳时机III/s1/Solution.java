package 动态规划.q123_买卖股票的最佳时机III.s1;

/**
 * 动态规划
 */
class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[5];
        dp[0] = Integer.MIN_VALUE;
        dp[2] = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], -prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
            dp[2] = Math.max(dp[2], dp[1] - prices[i]);
            dp[3] = Math.max(dp[3], dp[2] + prices[i]);
        }
        return dp[3];
    }
}