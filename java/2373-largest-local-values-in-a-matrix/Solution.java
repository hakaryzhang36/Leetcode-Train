// Leetcode 2373-largest-local-values-in-a-matrix
class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] ans = new int[grid.length-2][grid.length-2];

        for (int si = 0; si < grid.length - 2; si++) {
            for (int sj = 0; sj < grid.length - 2; sj++) {
                for (int l = 0; l <= 2; l++) {
                    for (int r = 0; r <= 2; r++) {
                        if (ans[si][sj] < grid[si + l][sj + r]) {
                            ans[si][sj] = grid[si + l][sj + r];
                        }
                    }
                }
            }
        }
        return ans;
    }
}