// Leetcode 135-candy
// marked
// AMAZING IDEA! But still fail...
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> r = new ArrayList<>();
        int up = 0, down = matrix.length-1, left = 0, right = matrix[0].length-1;

        int i = 0, j = -1;

        while(true) {
            while(j+1 <= right) {
                j += 1;
                r.add(matrix[i][j]);
            }
            up++;

            if(up > down) break;

            while(i+1 <= down){
                i += 1;
                r.add(matrix[i][j]);
            }
            right--;

            if(left > right) break;

            while(j-1 >= left) {
                j -= 1;
                r.add(matrix[i][j]);
            }
            down--;

            if(up > down) break;

            while(i-1 >= up){
                i -= 1;
                r.add(matrix[i][j]);
            }
            left++;

            if(left > right) break;
        }

        return r;
    }
}