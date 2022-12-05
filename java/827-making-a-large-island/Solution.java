// Leetcode 827-making-a-large-island
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int[][] id;
    int[][] grid;
    int max = 0;
    public int largestIsland(int[][] grid) {
        this.grid = grid;
        this.id = new int[grid.length][grid[0].length];
        int num = 1;
        // 标号岛屿，记录大小
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && id[i][j] == 0) {
                    map.put(num, travelDFS(i, j, num));
                    max = Math.max(max, map.get(num));
                    num++;
                }
            }
        }
        
        // 尝试填海
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> ids = new HashSet<>();
                    int size = 1;
                    if (!ids.contains(getId(i+1, j)) && getId(i+1, j) != 0) {
                        size += map.get(getId(i+1, j));
                        ids.add(getId(i+1, j));
                    }
                    if (!ids.contains(getId(i-1, j)) && getId(i-1, j) != 0) {
                        size += map.get(getId(i-1, j));
                        ids.add(getId(i-1, j));
                    }
                    if (!ids.contains(getId(i, j+1)) && getId(i, j+1) != 0) {
                        size += map.get(getId(i, j+1));
                        ids.add(getId(i, j+1));
                    }
                    if (!ids.contains(getId(i, j-1)) && getId(i, j-1) != 0) {
                        size += map.get(getId(i, j-1));
                        ids.add(getId(i, j-1));
                    }
                    max = Math.max(max, size);
                }
            }
        }
        return max;
    }

    
    private int travelDFS(int i, int j, int num) {
        // 非法i/j，或者走到海里了
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || id[i][j] != 0) {
            return 0;
        }
        id[i][j] = num;

        int res = 1;
        res += travelDFS(i+1, j, num);
        res += travelDFS(i-1, j, num);
        res += travelDFS(i, j+1, num);
        res += travelDFS(i, j-1, num);
        return res;
    }

    private int getId(int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        else {
            return id[i][j];
        }
    }
}