// Leetcode 48-rotate-image
class Solution {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        for (int m1 = 0, m2 = size - 1; m1 < size; m1++, m2--) {
            for (int j = m2, i = m1; j >= 0; i++, j--) {
                int t = matrix[m1][j];
                matrix[m1][j] = matrix[i][m2];
                matrix[i][m2] = t;
            }
        }
        for (int t = 0, l = size - 1; t < l; t++, l--) {
            for (int w = 0; w < size; w++) {
                int g = matrix[t][w];
                matrix[t][w] = matrix[l][w];
                matrix[l][w] = g;
            }
        }
    }
}