// Leetcode 59
// mark
public class Solution {
    public int[][] generateMatrix(int n) {
        int maxStep = n - 1, step = 1;
        int[][] m = new int[n][n];
        for (int c = 1, i = 0, k = 0; c <= n * n; ) {
            // write in the last position
            if (maxStep == 0) {
                m[i][k] = c;
                break;
            }
            // go right
            while (c <= n * n && step <= maxStep) {
                m[i][k] = c;
                c++;
                step++;
                k++;
            }
            step = 1;
            // go down
            while (c <= n * n && step <= maxStep) {
                m[i][k] = c;
                c++;
                step++;
                i++;
            }
            step = 1;
            // go left
            while (c <= n * n && step <= maxStep) {
                m[i][k] = c;
                c++;
                step++;
                k--;
            }
            step = 1;
            // go up
            while (c <= n * n && step <= maxStep) {
                m[i][k] = c;
                c++;
                step++;
                i--;
            }
            step = 1;
            maxStep -= 2;
            i++;
            k++;
        }
        return m;
    }
}