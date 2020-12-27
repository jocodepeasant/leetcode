package 动态规划.q714_买卖股票的最佳时机含手续费.s2;

/**
 * 动态规划：
 * 空间优化，只用两个变量，当前所得的最大金额只与前一次的有关
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        //dp1：持有，dp2：不持有
        int dp1 = -prices[0] - fee, dp2 = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = dp1;
            dp1 = Math.max(dp2 - prices[i] - fee, dp1);
            dp2 = Math.max(dp2, tmp + prices[i]);
        }
        return dp2;
    }
}