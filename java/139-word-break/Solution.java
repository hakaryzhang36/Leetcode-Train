// Leetcode 139-word-break
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }
        boolean[] dp = new boolean[s.length()];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            for (int k = i - 1; k >= 0; k--) {
                if (dp[k]) {
                    String sub = s.substring(k+1, i+1);
                    if (wordSet.contains(sub)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            dp[i] = dp[i] ? true : wordSet.contains(s.substring(0, i+1));
        }
        return dp[s.length()-1];
    }
}