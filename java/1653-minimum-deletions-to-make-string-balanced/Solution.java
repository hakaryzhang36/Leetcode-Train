// Leetcode 1653-minimum-deletions-to-make-string-balanced
class Solution {
    public int minimumDeletions(String s) {
        int[] lb = new int[s.length()];
        int[] ra = new int[s.length()];
        int b = 0;
        int a = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) == 'b') {
                ++b;
            }
            lb[i] = b;
        }
        for (int i = s.length()-2; i >= 0; i--) {
            if (s.charAt(i+1) == 'a') {
                ++a;
            }
            ra[i] = a;
        }

        int ans = -1;
        for (int i = 0; i < s.length(); i++) {
            ans = ans == -1 ? lb[i] + ra[i] : Math.min(ans, lb[i] + ra[i]);
        }
        return ans;
    }
}