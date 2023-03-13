// Leetcode 309-best-time-to-buy-and-sell-stock-with-cooldown
// mark
// done
class Solution {
    public int maxProfit(int[] prices) {
        // dp[d][0]: 第d天持有股票的最大利润
        // dp[d][1]: 第d天不持有股票的最大利润
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int d = 1; d < prices.length; d++) {
            int t = d-2>=0 ? dp[d-2][1] : 0; // 前天不持有的最大利润
            dp[d][0] = Math.max(t-prices[d], dp[d-1][0]);
            dp[d][1] = Math.max(dp[d-1][0]+prices[d], dp[d-1][1]);
        }
        return dp[prices.length-1][1];
    }
}