// Leetcode 240-search-a-2d-matrix-ii
// mark
// better solution
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = -1;
        int j = -1;
        for (; j+1 < matrix[0].length && matrix[0][j+1] <= target; j++){}
        if (j < 0) return false;
        if (matrix[0][j] == target) return true;
        for (; j >= 0 && i+1 < matrix.length; i++) {
            if (matrix[i+1][j] == target) return true;
            if (matrix[i+1][j] > target) {
                j-=1;
                if (j >= 0 && matrix[i][j] == target) return true;
                i--;
            }
        }

        return false; 
    }
}