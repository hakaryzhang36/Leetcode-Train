// Leetcode 01.07-rotate-matrix-lcci
class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix[i].length; j++) {
                int k = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = k;
            }
        }
        for (int i = 0, j = matrix[0].length-1; i < j; i++, j--) {
            for (int m = 0; m < matrix.length; m++) {
                int k = matrix[m][i];
                matrix[m][i] = matrix[m][j];
                matrix[m][j] = k;
            }
        }
    }
}