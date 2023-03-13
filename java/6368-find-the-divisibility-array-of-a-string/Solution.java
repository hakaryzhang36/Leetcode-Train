// Leetcode 6368-find-the-divisibility-array-of-a-string
class Solution {
    public int[] divisibilityArray(String word, int m) {
        int[] div = new int[word.length()];
        long t = 0;
        long num = word.charAt(0) - '0';
        for (int i = 0; i < word.length(); i++) {
            num = t*10 + word.charAt(i) - '0';
            t = num % m;
            if (num % m == 0L) {
                div[i] = 1;
            }
            else {
                div[i] = 0;
            }
        }
        return div;
    }
}