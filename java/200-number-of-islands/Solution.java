// Leetcode 200-number-of-islands
class Solution {
    boolean[][] m = null;
    char[][] grid = null;
    public int numIslands(char[][] grid) {
        if (grid == null) return 0;

        m = new boolean[grid.length][grid[0].length];
        this.grid = grid;

        int res = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!m[i][j] && grid[i][j] == '1') {
                    res++;
                    dfs(i, j);
                }
            }
        }

        return res;
    }

    public void dfs(int i, int j) {
        if(i < 0 || i > grid.length-1 || j < 0 || j > grid[0].length-1) return;

        if(m[i][j] || grid[i][j] == '0') return;

        m[i][j] = true;

        dfs(i-1, j);
        dfs(i+1, j);
        dfs(i, j-1);
        dfs(i, j+1);
    }
}