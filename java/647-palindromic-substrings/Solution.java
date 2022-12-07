// Leetcode 647-palindromic-substrings
// mark
/**
 * 没有简单的方法，直接搞，动态规划反而还难了。
 */
class Solution {
    public int countSubstrings(String s) {
        int res = s.length();
        // dpij，以 Si 结尾的，长度为 j 的回文子串是否存在
        boolean[][] dp = new boolean[s.length()][s.length() + 1];
        dp[0][0] = true;
        dp[0][1] = true;
        for (int i = 1; i < s.length(); i++) {
            dp[i][0] = true;
            dp[i][1] = true;
            // 最长只能到 i + 1
            for (int j = 0; j <= i - 1; j++) {
                if (dp[i-1][j] && s.charAt(i) == s.charAt(i - 1 - j)) {
                    dp[i][j+2] =  true;
                    res++;
                }
            }
        }
        return res;
    }
}