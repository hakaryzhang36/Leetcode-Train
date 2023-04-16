// Leetcode 85-maximal-rectangle
// mark
// done but not perfect
class Solution {
    int max = 0;
    int rows = 0, cols = 0;
    char[][] matrix = null;
    public int maximalRectangle(char[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        this.matrix = matrix;
        int[] table = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                table[j] = matrix[i][j]!='0' ? table[j]+1 : 0; 
            }
            getRectangleSize(table);
        }
        return max;
    }

    public void getRectangleSize(int[] table) {
        int cols = table.length;
        for (int w = 1; w <= cols; w++) {
            // init window
            Deque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < w; i++) {
                while (!q.isEmpty() && table[q.peekLast()] >= table[i]) {
                    q.pollLast();
                }
                q.addLast(i);
            }
            max = Math.max(max, w*table[q.peekFirst()]);
            for (int s = 1; s+w-1 < cols; s++) {
                if (s-1 == q.peekFirst()) q.pollFirst();
                while (!q.isEmpty() && table[q.peekLast()] >= table[s+w-1]) {
                    q.pollLast();
                }
                q.addLast(s+w-1);
                max = Math.max(max, w*table[q.peekFirst()]);
            }
        }
    }
}