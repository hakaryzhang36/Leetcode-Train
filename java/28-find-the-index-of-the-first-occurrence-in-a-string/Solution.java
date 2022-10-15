// Leetcode 28-find-the-index-of-the-first-occurrence-in-a-string
// mark
class Solution {
    public int strStr(String haystack, String needle){
        int[] next = getNext(needle);
        for (int i = 0, j = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                if (j == needle.length()) {
                    return i - needle.length() + 1;
                }
            } else {
                j = next[j];
                if (j == -1) {
                    j = 0;
                } else {
                    i--;
                }
            }
        }
        return -1;
    }

    /*
    * What does next[i] represent for?
    * When needle[j] != haystack[i], next step should be let needle[next[j]] compare with haystack[i].
    * */
    public int[] getNext(String s) {
        int [] next = new int[s.length()];
        next[0] = 0;
        // Step 1
        // Let next[i] mean the size of the longest public prefix suffix string(最长公共前后缀串) of s[0:i]
        for (int i = 1, j = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                next[i] = j;
            } else if (i == 1) {    // s[0] != s[1], specialize
                next[i] = 0;
            } else if (j > 0 && s.charAt(i) == s.charAt(next[j - 1])) { // IMPORTANT
                next[i] = next[j - 1] + 1;
                j = next[j - 1] + 1;
            }
            else {
                next[i] = 0;
                j = 0;
            }
        }
        // Step 2
        // Convert next into prefix table
        for (int i = next.length - 1; i > 0; i--) {
            next[i] = next[i - 1];
        }
        next[0] = -1;
        return next;
    }
}