// Leetcode 5-longest-palindromic-substring
// mark
// done
class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int mi = 0;
        int mj = 0; 
        for (int step = 0; step < s.length(); step++) {
            for (int i = 0; i < s.length()-step; i++) {
                int j = i+step;
                if (i==j) {
                    dp[i][j] = true;
                }
                else if (i == j-1 && s.charAt(i)==s.charAt(j)){
                    dp[i][j] = true;
                    if (mj-mi == 0) {
                        mi = i;
                        mj = j;
                    }
                }
                else if (dp[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    if (j-i > mj-mi) {
                        mi = i;
                        mj = j;
                    }
                }
            }
        }
        return s.substring(mi, mj+1);
    }
}