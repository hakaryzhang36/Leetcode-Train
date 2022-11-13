// Leetcode 494-target-sum
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // dp[i][j] 表示 从 1 到 i 的物品，能填满大小为 j 的背包的组合数
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum < target || -sum > target) {
            return 0;
        }
        int[][] dp = new int[nums.length][sum * 2 + 1];
        // 初始化，尝试放入 +- nums[0] 到 所有背包（只能填满2个背包）
        for (int j = 0; j < sum * 2 + 1; j++) {
            if (j == sum + nums[0]) {
                dp[0][j] += 1;
            }
            if (j == sum - nums[0]) {
                dp[0][j] += 1;
            }
        }
        // 遍历 nums
        for (int i = 1; i < nums.length; i++) {
            // 从小到大的背包，统计组合数
            for (int j = 0; j < sum * 2 + 1; j++) {
                int c = 0;
                int p1 = j - nums[i];
                int p2 = j + nums[i];
                c = c + (p1 >= 0 ? dp[i - 1][p1] : 0);
                c = c + (p2 < dp[i].length ? dp[i - 1][p2] : 0);
                dp[i][j] = c;
            }
        }
        return dp[nums.length - 1][sum + target];
    }
}