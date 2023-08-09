// Leetcode offer-04
// mark, have a great solution
class Solution {
    int[][] matrix = null;
    int target = 0;
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        this.matrix = matrix;
        this.target = target;
        int i = 0, j = 0;
        while (true) {
            i = down(i, j);
            if (i < 0) return false;
            if (matrix[i][j] == target) return true;
            j++;
            if (j >= matrix[0].length) return false;
            else if (matrix[i][j] > target) i = up(i, j);
            else i = down(i, j);
        }
    }

    private int down(int i, int j) {
        while (i < matrix.length) {
            if (matrix[i][j] == target) return i;
            if (matrix[i][j] > target) return i-1;
            i++;
        }
        return i-1;
    }

    private int up(int i, int j) {
        while (i >= 0) {
            if (matrix[i][j] == target) return i;
            if (matrix[i][j] < target) return i+1;
            i--;
        }
        return i+1;
    }
}
