// Leetcode 72-edit-distance
// mark
// 能解出来的困难题！
// 然后几个月后再看就不会了……
class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        // 当前 word1 子串变成 word2 1-i 子串的最小操作数，dp0 表示变成空串
        int[] dp = new int[word2.length() + 1];

        // 初始化，子串 w1[0] 变成 word2 1-i 的子串，需要的最小操作数
        dp[0] = 1;
        for (int i = 1; i <= word2.length(); i++) {
            // 如果 word1[0] 等于 word[i-1] (子串的最后一个字母)，最小操作数为 i - 1（插入前面缺少 i-1 个字母）
            if (word1.charAt(0) == word2.charAt(i-1)) {
                dp[i] = Math.min(dp[i-1], i-1);
            }
            else {
                // 如果不等于，为 i（替换+插入）
                dp[i] = Math.min(dp[i-1] + 1, i);
            }
            // System.out.print(dp[i]);
        }
        
        // 求 word1 1-k子串的最小操作数
        for (int k = 2; k <= word1.length(); k++) {
            int[] dp_t = new int[word2.length() + 1];
            dp_t[0] = k;  // 全删
            for (int i = 1; i <= word2.length(); i++) {
                if (word1.charAt(k-1) == word2.charAt(i-1)) {
                    dp_t[i] = Math.min(dp[i-1], Math.min(dp[i] + 1, dp_t[i-1]+1));
                }
                else {
                    dp_t[i] = Math.min(Math.min(dp[i-1] + 1, dp[i] + 1), dp_t[i-1] + 1);
                }
            }
            dp = dp_t;
        }

        return dp[word2.length()];
    }
}