// Leetcode 200-number-of-islands
class Solution {
    char[][] grid;
    boolean[][] mark;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.mark = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !mark[i][j]) {
                    count++;
                    travelDFS(i, j);
                }
            }
        }
        return count;
    }

    private void travelDFS(int i, int j) {
        mark[i][j] = true;
        if (grid[i][j] == '0') {
            return;
        }
        else {
            if (i + 1 < grid.length && !mark[i+1][j]) {
                travelDFS(i+1, j);
            }
            if (i - 1 >= 0 && !mark[i-1][j]) {
                travelDFS(i-1, j);
            }
            if (j + 1 < grid[0].length && !mark[i][j+1]) {
                travelDFS(i, j+1);
            }
            if (j - 1 >= 0 && !mark[i][j-1]) {
                travelDFS(i, j-1);
            }
        }
    }
}