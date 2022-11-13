// Leetcode 416-partition-equal-subset-sum
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int[] dp = new int[sum / 2 + 1];
        // init
        // 塞入第一件物品
        for (int j = sum / 2; j >= 0; j--) {
            if (j >= nums[0]) {
                dp[j] = nums[0];
            }
        }

        // 遍历 nums
        for (int i = 1; i < nums.length; i++) {
            // 背包从大到小，尝试塞入
            for (int j = sum / 2; j >= 0; j--) {
                int p = j - nums[i];
                int value = p > 0 ? dp[p] + nums[i] : 0;
                dp[j] = Math.max(dp[j], value);
            }
        }
        if (dp[sum / 2] == sum / 2) {
            return true;
        }
        else {
            return false;
        }
    }
}