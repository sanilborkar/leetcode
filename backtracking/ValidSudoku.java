/**
 * Problem   : https://leetcode.com/problems/valid-sudoku/
 * Submission: https://leetcode.com/submissions/detail/125753685/
 */

class Solution {
    private static final char DOT = '.'; 
    
    private boolean setValue(boolean[] found, char c) {
        if (c != DOT) {
            if (found[c - '0']) return false;
                    
            found[c - '0'] = true;
        }
        
        return true;
    }
    
    private boolean checkRows(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            boolean[] found = new boolean[10];
            
            for (int col = 0; col < board[0].length; col++) {
                if (!setValue(found, board[row][col])) return false;
            }
        }
        
        return true;
    }
    
    private boolean checkCols(char[][] board) {
        for (int col = 0; col < board[0].length; col++) {
            boolean[] found = new boolean[10];
            
            for (int row = 0; row < board.length; row++) {
                if (!setValue(found, board[row][col])) return false;
            }
        }
        
        return true;
    }
    
    private boolean isValidSquare(char[][] board, int rowStart, int colStart) {
        boolean[] found = new boolean[10];
        
        for (int row = rowStart; row < rowStart + 3; row++) {
            for (int col = colStart; col < colStart + 3; col++) {
                if (!setValue(found, board[row][col])) return false;
            }
        }
        
        return true;
    }
    
    private boolean checkSquares(char[][] board) {
        for (int rowBlock = 0; rowBlock < 3; rowBlock++) {
            for (int colBlock = 0; colBlock < 3; colBlock++) {
                if (!isValidSquare(board, 3*rowBlock, 3*colBlock))
                    return false;
            }
        }
        
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board[0].length == 0 || board.length == 0)
            return true;
        
        // Check rows, cols and squares
        if (!checkRows(board) || !checkCols(board) || !checkSquares(board))
            return false;
        
        return true;
    }
}
