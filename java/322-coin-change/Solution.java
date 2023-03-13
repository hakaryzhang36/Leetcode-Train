// Leetcode 322-coin-change
// mark
// done
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount==0) {
            return 0;
        }
        int[] dp = new int[amount+1];
        for (int total = 1; total <= amount; total++) {
            dp[total] = -1;
            for (int i = 0; i < coins.length; i++) {
                if (total - coins[i] >= 0 && dp[total - coins[i]]!= -1) {
                    dp[total] = dp[total]!=-1?Math.min(dp[total - coins[i]] + 1, dp[total]):dp[total-coins[i]]+1;
                }
            }
        }
        return dp[amount];
    }
}