package 动态规划.q714_买卖股票的最佳时机含手续费.s1;

/**
 * 动态规划：以股票的持有状态作为状态量
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        //dp[i][0]：持有，dp[i][1]：不持有
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] - prices[i] - fee, dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[len - 1][1];
    }
}