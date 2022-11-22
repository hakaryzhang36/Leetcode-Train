// Leetcode offer-12
class Solution {
    String word;
    char[][] board;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // find the first letter
                if (board[i][j] == this.word.charAt(0)) {
                    boolean[][] mark = new boolean[board.length][board[0].length];
                    if (reverse(mark, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

                    
    public boolean reverse(boolean[][] mark, int i, int j, int w) {
        // terminal
        if (w == word.length() - 1) {
            return true;
        }
        // mark
        mark[i][j] = true;
        // up
        if (i+1 < board.length && !mark[i+1][j] && board[i+1][j] == word.charAt(w+1)) {
            if (reverse(mark, i+1, j, w+1)) {
                return true;
            }
        }
        // down
        if (i-1 >= 0 && !mark[i-1][j] && board[i-1][j] == word.charAt(w+1)) {
            if (reverse(mark, i-1, j, w+1)) {
                return true;
            }
        }
        // left
        if (j-1 >= 0 && !mark[i][j-1] && board[i][j-1] == word.charAt(w+1)) {
            if (reverse(mark, i, j-1, w+1)) {
                return true;
            }
        }
        // right
        if (j+1 < board[0].length && !mark[i][j+1] && board[i][j+1] == word.charAt(w+1)) {
            if (reverse(mark, i, j+1, w+1)) {
                return true;
            }
        }
        // cancel mark
        mark[i][j] = false;
        return false;
    }
}