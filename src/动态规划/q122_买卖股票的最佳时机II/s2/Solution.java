package 动态规划.q122_买卖股票的最佳时机II.s2;

/**
 * 动态规划
 */
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        //0:不持有 1:持有
        int[][] dp = new int[len][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        //最后肯定是没有持有股票
        return dp[len - 1][0];
    }
}