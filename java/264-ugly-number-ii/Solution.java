// Leetcode 264-ugly-number-ii
// mark
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        Set<Integer> set = new HashSet<>();
        set.add(1);
        dp[1] = 1;
        int a = 1;
        int b = 1;
        int c = 1;
        int i = 2;
        while (i <= n) {
            while (set.contains(dp[a]*2)) {
                a++;
            }
            while (set.contains(dp[b]*3)) {
                b++;
            }
            while (set.contains(dp[c]*5)) {
                c++;
            }
            dp[i] = Math.min(dp[a]*2, dp[b]*3);
            dp[i] = Math.min(dp[i], dp[c]*5);
            set.add(dp[i]);            
            i++;
        }
        return dp[n];
    }
}