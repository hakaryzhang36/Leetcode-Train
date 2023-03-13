// Leetcode 678-valid-parenthesis-string
// mark
class Solution {
    String s;
    public boolean checkValidString(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i+len-1 < s.length(); i++) {
                int j = i+len-1;
                char c1 = s.charAt(i);
                char c2 = s.charAt(j);
                if (len == 1) {
                    dp[i][i] = (c1=='*');
                }
                else if (len == 2) {
                    dp[i][j] = (c1 == '(' || c1 == '*') && (c2 == ')' || c2 == '*');
                }
                else if (dp[i+1][j-1] && (c1 == '(' || c1 == '*') && (c2 == ')' || c2 == '*')) {
                    dp[i][j] = true;
                }
                else {
                    for (int k = i; k < j; k++) {
                        if (dp[i][k] && dp[k+1][j]) {
                            dp[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][s.length()-1];
    }
}