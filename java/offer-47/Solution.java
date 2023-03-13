// Leetcode offer-47
class Solution {
    public int maxValue(int[][] grid) {
        int[][] mv = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int a = i-1>=0?mv[i-1][j]:0;
                int b = j-1>=0?mv[i][j-1]:0;
                mv[i][j] = grid[i][j] + Math.max(a, b);
                System.out.println(mv[i][j]);
            }
        }
        return mv[grid.length-1][grid[0].length-1];
    }
}