// Leetcode 121-best-time-to-buy-and-sell-stock
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i]-minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return profit;
    }
}