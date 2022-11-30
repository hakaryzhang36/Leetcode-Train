// Leetcode 300-longest-increasing-subsequence
class Solution {
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int k = 0; k < i; k++) {
                if (nums[k] < nums[i] && dp[k] + 1 > dp[i]) {
                    dp[i] = dp[k] + 1;
                }
            }
            if (res < dp[i]) {
                res = dp[i];
            }
        }
        return res;
    }
}