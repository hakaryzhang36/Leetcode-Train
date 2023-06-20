// Leetcode 5-longest-palindromic-substring
// mark-2
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

class Solution {
    public String longestPalindrome(String s) {
        String res = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            int k = 1;
            while(i-k >= 0 && i+k < s.length()) {
                if(s.charAt(i-k) != s.charAt(i+k)) break;
                else if (res.length() < 1 + 2*k) {
                    res = s.substring(i-k, i+k+1);
                }
                k++;
            }
        }  
        for (int i = 0; i < s.length(); i++) {
            int k = 0;
            while(i-k >= 0 && i+k+1 < s.length()) {
                if(s.charAt(i-k) != s.charAt(i+k+1)) break;
                else if (res.length() < 2*k+2) {
                    res = s.substring(i-k, i+k+2);
                }
                k++;
            }
        }   
        return res;    
    }
}