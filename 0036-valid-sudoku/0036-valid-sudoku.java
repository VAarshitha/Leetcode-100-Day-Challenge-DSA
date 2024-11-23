import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check rows, columns, and 3x3 sub-boxes
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> box = new HashSet<>();
            
            for (int j = 0; j < 9; j++) {
                // Check row
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                
                // Check column
                if (board[j][i] != '.' && !cols.add(board[j][i])) {
                    return false;
                }
                
                // Check 3x3 sub-box
                int rowIndex = 3 * (i / 3) + j / 3;
                int colIndex = 3 * (i % 3) + j % 3;
                if (board[rowIndex][colIndex] != '.' && !box.add(board[rowIndex][colIndex])) {
                    return false;
                }
            }
        }
        return true;
    }
}
