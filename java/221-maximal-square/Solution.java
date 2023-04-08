// Leetcode 221-maximal-square
// mark
// done, but not the best
class Solution {
    char[][] matrix;
    public int maximalSquare(char[][] matrix) {
        this.matrix = matrix;
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                boolean isSquare = true;
                for (int trySize = 1; isSquare && i+trySize-1 < matrix.length && j+trySize-1 < matrix[0].length; trySize++) {
                    if (isSquare = cheak(i, j, trySize)) {
                        max = Math.max(max, trySize*trySize);
                    }
                }
            }
        }
        return max;
    }

    public boolean cheak(int i, int j, int trySize) {
        // System.out.println(i + " " + j);
        for(int p = i, q = j+trySize-1; p < i+trySize; p++) {
            if (matrix[p][q] != '1') {
                // System.out.println(p + " " + q);
                return false;
            }
        }
        for(int p = i+trySize-1, q = j; q < j+trySize; q++) {
            if (matrix[p][q] != '1') {
                return false;
            }
        }
        return true;
    }
}