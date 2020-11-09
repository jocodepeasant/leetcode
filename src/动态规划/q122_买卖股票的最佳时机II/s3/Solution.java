package 动态规划.q122_买卖股票的最佳时机II.s3;

/**
 * 动态规划,空间优化O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        //0:不持有 1:持有
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < len; i++) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        //最后肯定是没有持有股票
        return dp0;
    }
}