// Leetcode 62-unique-paths
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int step = 0; step <= m+n-2; step++) {
            if (step == 0) {
                dp[0][0] = 1;
            }
            else {
                for (int r = 0; r <= step; r++) {
                    if (r > m-1) {
                        break;
                    }
                    if (step - r > n-1) {
                        continue;
                    }
                    if (r - 1 >= 0) {
                        dp[r][step - r] += dp[r - 1][step - r];
                    }
                    if (step - r - 1 >= 0) {
                        dp[r][step - r] += dp[r][step - r - 1];
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }
}