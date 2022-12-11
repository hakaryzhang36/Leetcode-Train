// Leetcode 64-minimum-path-sum
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int sum = 1; sum <= m + n - 2; sum++) {
            // i 不能超过 sum（按斜线更新），i 和 sum - i 不能溢出
            for (int i = 0; i <= sum; i++) {
                if (i >= m || sum - i >= n) continue;
                int upPath = i-1>=0 ? dp[i-1][sum-i] : Integer.MAX_VALUE;
                int leftPath = sum-i-1>=0 ? dp[i][sum-i-1] : Integer.MAX_VALUE;
                dp[i][sum - i] = Math.min(upPath, leftPath) + grid[i][sum-i];
            }
        }

        return dp[m-1][n-1];
    }
}