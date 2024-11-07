public class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Start a DFS search if the first character matches
                if (dfs(board, word, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        // If we've matched all characters in the word, return true
        if (index == word.length()) {
            return true;
        }

        // Check boundaries and if the cell matches the current character in the word
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Temporarily mark the cell as visited by replacing it with a placeholder character
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore in all 4 directions (down, up, right, left)
        boolean found = dfs(board, word, row + 1, col, index + 1) ||  // Down
                        dfs(board, word, row - 1, col, index + 1) ||  // Up
                        dfs(board, word, row, col + 1, index + 1) ||  // Right
                        dfs(board, word, row, col - 1, index + 1);    // Left

        // Backtrack by restoring the cell's original character
        board[row][col] = temp;

        return found;
    }
}
