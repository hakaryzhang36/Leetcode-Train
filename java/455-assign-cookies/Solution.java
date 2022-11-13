// Leetcode 455-assign-cookies
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        for (int i = 0, j = 0; i < s.length && j < g.length; i++) {
            if (g[j] <= s[i]) {
                j++;
                res++;
            }
        }
        return res;
    }
}