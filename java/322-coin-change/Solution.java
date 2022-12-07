// Leetcode 322-coin-change
// mark
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                // 硬币面值小于当前总额，并且存在可以达到 i - coins[j] 总额的组合
                if(i - coins[j] >= 0 && dp[i - coins[j]] < Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
}