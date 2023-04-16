// Leetcode 221-maximal-square
// good idea
class Solution {
    char[][] matrix = null;
    int[][] len = null;
    int max = 0;
    public int maximalSquare(char[][] matrix) {
        this.matrix = matrix;
        len = new int[matrix.length][matrix[0].length];
        len[0][0] = matrix[0][0]=='1'?1:0;
        max = len[0][0];
        for (int a = 1, b = 1; a < matrix.length || b < matrix[0].length; a++, b++) {
            if (a < matrix.length) {
                update_1(a, Math.min(b, matrix[0].length-1));
            }
            if (b < matrix[0].length) {
                update_2(Math.min(a, matrix.length-1), b);
            }
        }
        return max;
    }

    public void update_1(int a, int b) {
        for (int j = 0; j <= b; j++) {
            if (j == 0) {
                len[a][j] = matrix[a][j]=='1'?1:0;
            }
            else if (matrix[a][j] == '1') {
                len[a][j] = 1 + Math.min(len[a][j-1], Math.min(len[a-1][j], len[a-1][j-1]));
            }
            else {
                len[a][j] = 0;
            }
            max = Math.max(max, len[a][j]*len[a][j]);
        }
    }

    public void update_2(int a, int b) {
        for (int i = 0; i <= a; i++) {
            if (i == 0) {
                len[i][b] = matrix[i][b]=='1'?1:0;
            }
            else if (matrix[i][b] == '1') {
                len[i][b] = 1 + Math.min(len[i-1][b], Math.min(len[i][b-1], len[i-1][b-1]));
            }
            else {
                len[i][b] = 0;
            }
            max = Math.max(max, len[i][b]*len[i][b]);
        }
    }
}