package 动态规划.q122_买卖股票的最佳时机II.s1;

/**
 * 贪心
 */
class Solution {
    public int maxProfit(int[] prices) {
        int res=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                res+=prices[i]-prices[i-1];
            }
        }
        return res;
    }
}