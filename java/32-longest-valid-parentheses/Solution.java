// Leetcode 32-longest-valid-parentheses
class Solution {
    public int longestValidParentheses(String s) {
        // 以 i 结尾的最长串
        int[] len = new int[s.length()];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                // find len
                if (i-1>=0 ) {
                    // 如果前一个是（肯定要匹配，并尝试和 i-2 结尾串连上
                    if (s.charAt(i-1) == '(') {
                        int k = i-2>=0 ? len[i-2] : 0;
                        len[i] = 2 + k;
                    }
                    // 如果前一个是），看看能不能扩展以其结尾的最长串
                    if (s.charAt(i-1) == ')') {
                        int c = i-1-len[i-1];
                        if (c >= 0 && s.charAt(c) == '(') { 
                            // 如果能扩展，则再看扩展后的串能否后前面连上，因为扩展后串的起始位置变了，可能能和前面拼起来 () + (()) 
                            int t = c-1 >= 0 ? len[c-1] : 0;
                            len[i] = len[i-1] + 2 + t;
                        }
                    }
                }
                max = Math.max(len[i], max);
            }
        }
        return max;
    }
}