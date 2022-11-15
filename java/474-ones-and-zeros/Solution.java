// Leetcode 474-ones-and-zeros
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // mark the count of 0,1 of each string
        int[] zeros = new int[strs.length]; 
        int[] ones = new int[strs.length]; 
        int i_ = 0;
        for (String str : strs) {
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeros[i_]++;
                }
                else {
                    ones[i_]++;
                }
            }
            i_++;
        }

        int[][] dp = new int[m + 1][n + 1];
        // init
        for (int j = 0; j <= m; j++) {
            for (int k = 0; k <= n; k++) {
                if (j >= zeros[0] && k >= ones[0]) {
                    dp[j][k] = 1;
                }
                else {
                    dp[j][k] = 0;
                }
            }
        }

        // traverse strs, update dp[][]
        for (int i = 1; i < strs.length; i++) {
            // update dp from right-down to left-up
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    int temp = 0;
                    if (j - zeros[i] >= 0 && k - ones[i] >= 0) {
                        int j_ = j - zeros[i];
                        int k_ = k - ones[i];
                        temp = dp[j_][k_] + 1;
                    }
                    // update
                    dp[j][k] = Math.max(dp[j][k], temp);
                }
            }
            System.out.println(dp[m][n]);
        }

        return dp[m][n];
    }
}