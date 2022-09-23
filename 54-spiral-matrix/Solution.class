// Leetcode 54
// mark
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int iMaxStep = m - 1, kMaxStep = n - 1, iStep = 1, kStep = 1;
        for (int i = 0, k = 0, c = 1; c <= m * n;) {
            if (iMaxStep == 0 && kMaxStep == 0) {
                ans.add(matrix[i][k]);
                break;
            }
            while (c <= m * n && kStep <= kMaxStep) {
                ans.add(matrix[i][k]);
                kStep++;
                c++;
                k++;
            }
            kStep = 1;
            while (c <= m * n && iStep <= iMaxStep) {
                ans.add(matrix[i][k]);
                iStep++;
                c++;
                i++;
            }
            iStep = 1;
            while (c <= m * n && kStep <= kMaxStep) {
                ans.add(matrix[i][k]);
                kStep++;
                c++;
                k--;
            }
            kStep = 1;
            while (c <= m * n && iStep <= iMaxStep) {
                ans.add(matrix[i][k]);
                iStep++;
                c++;
                i--;
            }
            iStep = 1;
            i++;
            k++;
            iMaxStep -= 2;
            kMaxStep -= 2;
        }
        return ans;
    }
}