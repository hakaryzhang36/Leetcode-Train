// Leetcode 79-word-search
class Solution {
    char[][] board;
    String word;
    boolean[][] mark;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.mark = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (this.board[i][j] == this.word.charAt(0)) {
                    if (DFS(i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean DFS(int i, int j, int index) {
        mark[i][j] = true;
        if (index == word.length()-1) {
            return true;
        }
        if(i-1 >= 0 && !mark[i-1][j] && board[i-1][j] == word.charAt(index+1)) {
            if(DFS(i-1, j, index+1)){
                mark[i][j] = false;
                return true;
            }
        }
        if(i+1 < board.length && !mark[i+1][j] && board[i+1][j] == word.charAt(index+1)) {
            if(DFS(i+1, j, index+1)){
                mark[i][j] = false;
                return true;
            }
        }
        if(j-1 >= 0 && !mark[i][j-1] && board[i][j-1] == word.charAt(index+1)) {
            if(DFS(i, j-1, index+1)){
                return true;
            }
        }
        if(j+1 < board[0].length && !mark[i][j+1] && board[i][j+1] == word.charAt(index+1)) {
            if(DFS(i, j+1, index+1)){
                mark[i][j] = false;
                return true;
            }
        }
        mark[i][j] = false;
        return false;
    }
}
