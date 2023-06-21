// Leetcode 121-best-time-to-buy-and-sell-stock
class Solution {
    public int maxProfit(int[] prices) {
        int[] preMin = new int[prices.length];
        preMin[0] = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            preMin[i] = Math.min(preMin[i-1], prices[i]);
            max = Math.max(prices[i] - preMin[i-1], max);
        }
        return max;
    }
}