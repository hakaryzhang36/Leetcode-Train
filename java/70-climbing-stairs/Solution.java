// Leetcode 70-climbing-stairs
class Solution {
    public int climbStairs(int n) {
        int[] level = new int[n + 1];
        level[0] = 1;   
        level[1] = 1;
        for (int i = 2; i <= n; i++) {
            level[i] = level[i-1] + level[i-2];
        }
        return level[n];
    }
}